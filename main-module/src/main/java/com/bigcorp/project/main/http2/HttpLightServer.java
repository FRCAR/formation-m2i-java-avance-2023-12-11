package com.bigcorp.project.main.http2;

import java.io.IOException;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

public class HttpLightServer extends NanoHTTPD {
    
    public HttpLightServer() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nDémarré! Tester sur :  http://localhost:8080/ \n");
    }

    public static void main(String[] args) {
        try {
            new HttpLightServer();
        } catch (IOException ioe) {
            System.err.println("Démarrage impossible:\n" + ioe);
        }
    }

    @Override
    public Response serve(IHTTPSession session) {
        System.out.println("Je sers une page");
    	String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
        }
        
        return newFixedLengthResponse(msg + "</body></html>\n");
    }
}
