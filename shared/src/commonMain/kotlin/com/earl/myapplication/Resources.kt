package com.earl.myapplication

import com.earl.shared_resources.SharedResources
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.getImageByFileName

fun getImageByFileName(name: String): ImageResource {
    val fallbackImage = SharedResources.images.ic_run // fixme change dfefault icon to transparent
    return SharedResources.images.getImageByFileName(name) ?: fallbackImage
}