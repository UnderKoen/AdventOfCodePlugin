package com.github.underkoen.adventofcodeplugin.services

import com.intellij.openapi.project.Project
import com.github.underkoen.adventofcodeplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
