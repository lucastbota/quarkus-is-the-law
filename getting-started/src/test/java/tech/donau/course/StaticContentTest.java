package tech.donau.course;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

@QuarkusTest
public class StaticContentTest {
    @TestHTTPResource("index.html")
    URL url;

    @Test
    void testRootPath() throws IOException {
        var result = IOUtils.toString(url, Charset.defaultCharset());
        Assertions.assertTrue(result.contains("<h2>What is this page?</h2>"));
    }
}
