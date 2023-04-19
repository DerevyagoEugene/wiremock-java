package server;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.String.format;
import static java.lang.String.valueOf;

@UtilityClass
public class WireMockServer {

    private static final String CMD = "cmd.exe";
    private static final String COMMAND = "/c";
    private static final String DOCKER = "docker";

    public static void start(int port) {
        executeCmdCommand(new String[] {
                CMD,
                COMMAND,
                DOCKER,
                "run",
                "--rm",
                "-p",
                format("%1$s:%1$s", port),
                "--name",
                "wiremock",
                "wiremock/wiremock:2.35.0",
                "--port",
                valueOf(port)
        });
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String getContainerId() {
        var process = executeCmdCommand(new String[] {
                CMD,
                COMMAND,
                DOCKER,
                "ps",
                "-a",
                "-q",
                "--filter=\"name=wiremock*\""
        });
        try {
            return new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void stop() {
        var containerId = getContainerId();
        executeCmdCommand(new String[] {
                CMD,
                COMMAND,
                DOCKER,
                "stop",
                containerId
        });
    }

    private static Process executeCmdCommand(String[] args) {
        try {
            return Runtime.getRuntime().exec(args);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
