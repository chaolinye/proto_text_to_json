package org.freedom;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;
import com.google.protobuf.util.JsonFormat;
import org.freedom.proto.PersonProto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        String file = "data.txt";
        String data = IoUtil.read(new ClassPathResource(file).getStream(), StandardCharsets.UTF_8);
        System.out.println(protoTextToJson(data, PersonProto.Person.newBuilder()));
    }

    private static String protoTextToJson(String text, Message.Builder builder) throws IOException {
        TextFormat.merge(text, builder);
        return JsonFormat.printer().print(builder);
    }
}
