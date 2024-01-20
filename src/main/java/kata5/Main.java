package kata5;

import spark.Spark;

public class Main {
    public static void main(String[] args) {
        CommandExecutor.put("largestPrime", new LargestPrimeCommand());
        Spark.port(8080);
        Spark.get("/largestPrime", ((request, response) ->
                CommandExecutor.with(request, response).execute("largestPrime")));
    }
}