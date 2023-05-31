package exercise;

// BEGIN
import javax.swing.text.html.HTML;
import java.util.*;
import java.util.stream.Collectors;

public class PairedTag extends Tag {
    private String body;
    private List<Tag> children = new LinkedList<>();

    public PairedTag (String name, Map<String, String> tags, String body, List<Tag> children) {
        this.name = name;
        this.tags.putAll(tags);
        this.body = body;
        this.children.addAll(children);
    }

    public String toString() {
        Map<String, String> tempTags = new LinkedHashMap<>(tags);
        StringBuilder tagsToString = new StringBuilder();
        tagsToString.append("<");
        tagsToString.append(name);
        if (!tempTags.isEmpty()) {
            Iterator<Map.Entry<String, String>> iterator = tempTags.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                tagsToString.append(" ");
                tagsToString.append(entry.getKey());
                tagsToString.append("=\"");
                tagsToString.append(entry.getValue());
                tagsToString.append("\"");
                iterator.remove();
            }
        }
        tagsToString.append(">");
        tagsToString.append(body);
        if (!children.isEmpty()) {
            for (Tag singleTag : children) {
                tagsToString.append(singleTag.toString());
            }
        }
        tagsToString.append("</");
        tagsToString.append(name);
        tagsToString.append(">");

        String tagsToStringInString = tagsToString.toString();

        return tagsToStringInString;
    }

    }
// END
