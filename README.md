# Android Build Extension

A plugin for your Android project that gives you an additional information about the Build and the Builder.

> It's meant to be used for Debugging and/or QA purposes.

## 🚩 Table of Contents

- [Installation](#installation)
- [How to use](#how-to-use)
    - [Machine Extensions](#how-to-use)
    - [Git Extensions](#how-to-use)
- [License](#license)
- [Gradle Page](https://plugins.gradle.org/plugin/com.github.tsvetilian-ty.build-extension)

# Installation

- Add to repositories in your project `build.gradle`:

    ```groovy
    maven {
      url "https://plugins.gradle.org/m2/"
    }
    ```
    
 - In the same gradle file's dependencies add:

    ```groovy
   dependencies {
        classpath "gradle.plugin.com.github.tsvetilian-ty:build-extension:2.00.0"
    }
    ```
    
- To apply the plugin use the following in you `build.gradle` (app level):

    ```groovy
    apply plugin: "com.github.tsvetilian-ty.build-extension"
    ```
    > Apply it below Android's system plugins
    
 # How to use
 
List of all available `BuildConfig` extension values. All extensions should be called through `BuildConfig`
> The default value for all extension is an empty string.

| Machine Extensions | Description | Format |
| --- | --- | --- |
| `BUILD_DATE` | The date of the current build. | dd.MM.yyyy  |
| `BUILD_MACHINE` | The name of the builder's machine. |
| `BUILD_MACHINE_OS` | Builder's OS. |
| `BUILD_MACHINE_USER` | The user of the machine used for building. |
| `BUILD_TIME` | The time of the current build. | HH:mm:ss |

| Git Extensions | Description |
| --- | --- |
| `BUILD_GIT_BRANCH` | - |
| `BUILD_GIT_HASH` | - |
| `BUILD_GIT_USER_EMAIL` | - |
| `BUILD_GIT_USER_NAME` | - |
| `BUILD_GIT_LAST_COMMIT` | - |

# License
The Project is licensed under the terms of Apache License 2.0.
