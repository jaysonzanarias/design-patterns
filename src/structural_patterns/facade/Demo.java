package structural_patterns.facade;

import structural_patterns.facade.facade.VideoConversionFacade;

import java.io.File;

/**
 * https://refactoring.guru/design-patterns/facade/java/example
 * Output:
 * VideoConversionFacade: conversion started.
 * CodecFactory: extracting ogg audio...
 * BitrateReader: reading file...
 * BitrateReader: writing file...
 * AudioMixer: fixing audio...
 * VideoConversionFacade: conversion completed.
 */
public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}
