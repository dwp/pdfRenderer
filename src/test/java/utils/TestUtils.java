package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
public class TestUtils {
    public static String buildQuestion(String question, String answer) {
        return ((question == null || question.isEmpty()) ? "" : question + " ") + answer;
    }

    public String pathQuestionLabel(String rootPath, String element) {
        String elementDetail = StringUtils.substringBetween(rootPath, "<" + element + ">", "</" + element + ">");
        String question = StringUtils.substringBetween(elementDetail, "<QuestionLabel>", "</QuestionLabel>");
        return (question == null) ? "" : question.replaceAll("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public String pathAnswer(String rootPath, String element) {
        String elementDetail = StringUtils.substringBetween(rootPath, "<" + element + ">", "</" + element + ">");
        String answer = StringUtils.substringBetween(elementDetail, "<Answer>", "</Answer>");
        return (answer == null) ? "" : answer.replaceAll("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public String pathAnswerAddress(String rootPath, String element) {
        String elementDetail = StringUtils.substringBetween(rootPath, "<" + element + ">", "</" + element + ">");
        String answer = StringUtils.substringBetween(elementDetail, "<Answer>", "</Answer>");
        if (answer == null) return "";
        int postCode = answer.indexOf("<PostCode>");
        if (postCode == -1)postCode = answer.length();
        return answer.substring(0, postCode).replaceAll("\n", "").replaceAll("</Line>", " ").replaceAll("<Line>", " ").replaceAll("\\s+", " ").trim();
    }

    public String pathAnswerOther(String rootPath, String element, String otherElement) {
        String elementDetail = StringUtils.substringBetween(rootPath, "<" + element + ">", "</" + element + ">");
        String answer = StringUtils.substringBetween(elementDetail, "<Answer>", "</Answer>");
        if (answer == null) return "";
        else if (answer.equalsIgnoreCase("other") || answer.equalsIgnoreCase("another country")) {
            elementDetail = StringUtils.substringBetween(rootPath, "<" + otherElement + ">", "</" + otherElement + ">");
            answer = StringUtils.substringBetween(elementDetail, "<Answer>", "</Answer>");
            if (answer == null) return "";
        }
        return answer.replaceAll("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public Pair<String, String> pathQuestionLabelAnswer(String rootPath, String element) {
        return ImmutablePair.of(pathQuestionLabel(rootPath, element), pathAnswer(rootPath, element));
    }

    public Pair<String, String> pathQuestionLabelAnswerAddress(String rootPath, String element) {
        return ImmutablePair.of(pathQuestionLabel(rootPath, element), pathAnswerAddress(rootPath, element));
    }

    public List<Pair<String, String>> pathQuestionLabelAnswerTitle(String rootPath) {
        String[] titles = rootPath.split("<Title>");
        List<Pair<String, String>> details = new ArrayList<>();
        for (String title : titles){
            if (title.contains("</Title>")) details.add(ImmutablePair.of("", title.replaceAll("\n", "").substring(0, title.lastIndexOf("</Title>")).replaceAll("<Title>", " ").replaceAll("</Title>", " ").replaceAll("\\s+", " ").trim()));
        }
        return details;
    }

    public List<Pair<String, String>> pathQuestionLabelAnswerContent(String rootPath) {
        String[] contents = rootPath.split("<Content>");
        List<Pair<String, String>> details = new ArrayList<>();
        for (String content : contents){
            if (content.contains("</Content>"))details.add(ImmutablePair.of("", content.replaceAll("\n", "").substring(0, content.lastIndexOf("</Content>")).replaceAll("<Content>", " ").replaceAll("</Content>", " ").replaceAll("\\s+", " ").trim()));
        }
        return details;
    }

    public Pair<String,String> pathQuestionLabelAnswerOther(String rootPath, String element, String otherElement) {
        return ImmutablePair.of(pathQuestionLabel(rootPath, element), pathAnswerOther(rootPath, element, otherElement));
    }

    public List<Pair<String, String>> prepareTestData(String rootPath, List<String> elements) {
        return elements.stream().map(e -> pathQuestionLabelAnswer(rootPath, e)).collect(Collectors.toList());
    }

    public List<String> convertListOfPairsToListOfString(List<Pair<String, String>> details) {
        List<String> newDetails = details.stream().filter(s -> testPair(s)).map(s -> buildQuestion(s.getLeft(), s.getRight())).collect(Collectors.toList());
        return newDetails;
    }

    private boolean testPair(Pair<String, String> s) {
        if (s.getLeft() == null || s.getRight() == null || s.getRight().isEmpty()) { return false; }
        return true;
    }
}
