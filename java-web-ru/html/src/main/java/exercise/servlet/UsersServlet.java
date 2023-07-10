package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;


public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        //Path usersJson = Paths.get("src", "main", "resources", "users.json").toAbsolutePath().normalize();
        String users = Files.readString(Paths.get("src", "main", "resources", "users.json")
                .toAbsolutePath().normalize());
        ObjectMapper usersJson = new ObjectMapper();
        List usersList = usersJson.readValue(users, List.class);
        return usersList;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<Map> users = getUsers();
        StringBuilder html = new StringBuilder();
        html.append("""
  <html lang="ru">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity=
            "sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
  <body>
  <div class=\\"container\\">
  <a href=\\"/\\">Главная</a>
  <table>
  """);
        for (Map<String, String> user : users) {
            String id = user.get("id");
            String fullName = user.get("firstName") + " " + user.get("lastName");
            html.append("<tr>");
            html.append("<td>" + id + "</td>");
            html.append("<td><a href=\"/users/" + id + "\">" + fullName + "</a></td>");
            html.append("</tr>");
        }
        html.append("""
                    </table>
                    </div>
                </body>
            </html>
            """);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(html);
  
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        List<Map<String, String>> users = getUsers();
        Map<String, String> user = users.stream()
                .filter(u -> u.get("id").equals(id))
                .findAny()
                .orElse(null);
        if (user == null) {
            response.sendError(404);
            return;
        }
        StringBuilder userPage = new StringBuilder();
        userPage.append("""
                <html lang="ru">
                <head>
                  <meta charset="utf-8">
                  <title>Example application | User</title>
                  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity=
                          "sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                </head>
                <body>
                <div class=\\"container\\">
                <a href=\\"/users\\">Пользователи</a>
                <table>
                """);
        for(Map.Entry data : user.entrySet()) {
            userPage.append("<div>");
            userPage.append(data.getKey() + ": " + data.getValue());
            userPage.append("</div>");
        }
        userPage.append("""
                    </div>
                </body>
            </html>
            """);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(userPage);
    }
        // END
}
