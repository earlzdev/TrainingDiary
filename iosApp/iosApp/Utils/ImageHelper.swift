//
//  ImageHelper.swift
//  iosApp
//
//  Created by earl on 04.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

extension Image {
    init(resource: KeyPath<SharedRes.images, ImageResource>) {
        self.init(uiImage: SharedRes.images()[keyPath: resource].toUIImage()!)
    }
}
