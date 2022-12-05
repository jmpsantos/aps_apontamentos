/*Facade: Padrão de software que encapsula lógica e subsistemas de código complexos num simples ponto de acesso,
 *        é incrivelmente útil no que toca a agrupar subsistemas em camadas de organização e acesso, no entanto 
 *        no caso de agrupamento demasiado genérico corremos o risco de tornar uma facade num god-objeto, ou seja,
 *        um objeto demasiado ominisciente e desorganizado.
 *        Neste código exemplo  agrupamos diversos componentes de encoding numa só facade  Video Encoder
 *        efetivamente emcapsulando todo o processo de VideoEncoding
 * 
*/


public class VideoFile {
    private String name;
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }
}


public interface Codec {
}

public class MPEG4CompressionCodec implements Codec {
    public String type = "mp4";

}

public class OggCompressionCodec implements Codec {
    public String type = "ogg";
}   

public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}

public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}

public class AudioMixer {
    public File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}

/*https://refactoring.guru/design-patterns/facade*/