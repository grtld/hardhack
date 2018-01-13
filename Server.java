import java.util.List;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.apache.http.client.utils.URIBuilder

public class Server {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        
        String testURL = "/test?s=1&c=on";
        URIBuilder builder = new URIBuilder(testURL);
        List<NameValuePair> params = builder.getQueryParams();
        String sw = params.get(0).getValue();
        String command = params.get(1).getValue();
        
        //basically each url location launches new methods i think
        server.createContext(test, new MyHandler(sw, command));
        server.createContext("/test2", new MyHandler2());
        
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        String sw;
        String command;
        
        public MyHandler(String s, String c) {
            sw = s;
            command = c;
        }
        
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Switch: " + sw + ", Command: " + command;
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    static class MyHandler2 implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response 2 kek";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
