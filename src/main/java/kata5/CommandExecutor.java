package kata5;

import com.sun.net.httpserver.Request;
import org.eclipse.jetty.client.api.Response;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private static final Map<String, Command> commands = new HashMap<>();
    private final Request request;
    private final Response response;

    public CommandExecutor(Request request, Response response) {
        this.request = request;
        this.response = response;
    }
}
