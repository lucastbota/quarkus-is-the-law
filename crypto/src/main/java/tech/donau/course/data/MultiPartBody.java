package tech.donau.course.data;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

public class MultiPartBody {
    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream file;
    @FormParam("name")
    @PartType(MediaType.TEXT_PLAIN)
    private String name;

    public MultiPartBody() {
    }

    public MultiPartBody(InputStream file, String name) {
        this.file = file;
        this.name = name;
    }

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
