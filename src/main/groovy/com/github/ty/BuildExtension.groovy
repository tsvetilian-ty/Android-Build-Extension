package com.github.ty;
import org.gradle.api.*

class BuildExtension implements Plugin<Project> {

    @Override
    void apply(Project target) {

        def buildOnDate = target.task("buildDate") {
            addToConfig(target, "BUILD_DATE", new Date().format("dd.MM.yyyy"))
        }

        def buildOnMachine = target.task("buildMachine") {
            addToConfig(target, "BUILD_MACHINE", InetAddress.getLocalHost().hostName)
        }

        def buildOnMachineUserProfile = target.task("buildMachineUser") {
            addToConfig(target, "BUILD_MACHINE_USER", System.properties["user.name"].toString())
        }

        def buildOnMachineOs = target.task("buildMachineOS") {
            addToConfig(target, "BUILD_MACHINE_OS", System.properties["os.name"].toString())
        }

        def gitBranch = target.task("buildGitBranch") {
            addToConfig(target, "BUILD_GIT_BRANCH", commandRunner("git rev-parse --abbrev-ref HEAD"))
        }

        def gitHash = target.task("buildGitHash") {
            addToConfig(target, "BUILD_GIT_HASH", commandRunner("git rev-parse --short HEAD"))
        }

        def gitUser = target.task("buildGitUser") {
            addToConfig(target, "BUILD_GIT_USER_NAME", commandRunner("git config user.name"))
        }

        def gitEmail = target.task("buildGitEmail") {
            addToConfig(target, "BUILD_GIT_USER_EMAIL", commandRunner("git config user.email"))
        }

        groupSetter([buildOnDate, buildOnMachine, buildOnMachineUserProfile,
                     buildOnMachineOs, gitBranch, gitEmail, gitHash, gitUser])
    }

    private static void addToConfig(Project target, String key, String value) {
        target.android.defaultConfig.buildConfigField("String", key, "\"${value}\"")
    }

    private static void groupSetter(List<Task> tasks) {
        tasks.each {
            it.group = "build info"
        }
    }

    private static String commandRunner(String command) {
        def valueHolder = ""
        def runner = command.execute()
        runner.in.eachLine { valueHolder = it }
        runner.waitFor()

        return valueHolder
    }
}