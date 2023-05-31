package exercise;

// BEGIN
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> tags) {
        this.name = name;
        this.tags.putAll(tags);
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
        String tagsToStringInString = tagsToString.toString();

        return tagsToStringInString;
    }
}
// END
