package gov.dwp.carers.pdfrenderer.utils;

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
    private static final String OTHER = "other";
    private static final String ANOTHER_COUNTRY = "another country";
    public static String buildQuestion(final String question, final String answer) {
        return (question == null || question.isEmpty() ? "" : question + " ") + answer;
    }

    public String pathQuestionLabel(final String rootPath, final String element) {
        final String elementDetail = StringUtils.substringBetween(rootPath, "<" + element + ">", "</" + element + ">");
        final String question = StringUtils.substringBetween(elementDetail, "<QuestionLabel>", "</QuestionLabel>");
        return (question == null) ? "" : question.replaceAll("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public String pathAnswer(final String rootPath, final String element) {
        final String elementDetail = StringUtils.substringBetween(rootPath, "<" + element + ">", "</" + element + ">");
        final String answer = StringUtils.substringBetween(elementDetail, "<Answer>", "</Answer>");
        return (answer == null) ? "" : answer.replaceAll("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public String pathAnswerAddress(final String rootPath, final String element) {
        final String elementDetail = StringUtils.substringBetween(rootPath, "<" + element + ">", "</" + element + ">");
        final String answer = StringUtils.substringBetween(elementDetail, "<Answer>", "</Answer>");
        String answerAddress = "";
        if (answer != null) {
            int postCode = answer.indexOf("<PostCode>");
            if (postCode == -1) {
                postCode = answer.length();
            }
            answerAddress = answer.substring(0, postCode).replaceAll("\n", "").replaceAll("</Line>", " ").replaceAll("<Line>", " ").replaceAll("\\s+", " ").trim();
        }
        return answerAddress;
    }

    public String pathAnswerOther(final String rootPath, final String element, final String otherElement) {
        String elementDetail = StringUtils.substringBetween(rootPath, "<" + element + ">", "</" + element + ">");
        String answer = StringUtils.substringBetween(elementDetail, "<Answer>", "</Answer>");
        String answerOther = "";
        if (answer != null && OTHER.equalsIgnoreCase(answer) || ANOTHER_COUNTRY.equalsIgnoreCase(answer)) {
            elementDetail = StringUtils.substringBetween(rootPath, "<" + otherElement + ">", "</" + otherElement + ">");
            answer = StringUtils.substringBetween(elementDetail, "<Answer>", "</Answer>");
        }
        if (answer != null) {
            answerOther = answer.replaceAll("\n", " ").replaceAll("\\s+", " ").trim();
        }
        return answerOther;
    }

    public Pair<String, String> pathQuestionLabelAnswer(final String rootPath, final String element) {
        return ImmutablePair.of(pathQuestionLabel(rootPath, element), pathAnswer(rootPath, element));
    }

    public Pair<String, String> pathQuestionLabelAnswerAddress(final String rootPath, final String element) {
        return ImmutablePair.of(pathQuestionLabel(rootPath, element), pathAnswerAddress(rootPath, element));
    }

    public List<Pair<String, String>> pathQuestionLabelAnswerTitle(final String rootPath) {
        final String[] titles = rootPath.split("<Title>");
        final List<Pair<String, String>> details = new ArrayList<>();
        for (final String title : titles){
            if (title.contains("</Title>")) {
                details.add(ImmutablePair.of("", title.replaceAll("\n", "").substring(0, title.lastIndexOf("</Title>")).replaceAll("<Title>", " ").replaceAll("</Title>", " ").replaceAll("\\s+", " ").trim()));
            }
        }
        return details;
    }

    public List<Pair<String, String>> pathQuestionLabelAnswerContent(final String rootPath) {
        final String[] contents = rootPath.split("<Content>");
        final List<Pair<String, String>> details = new ArrayList<>();
        for (final String content : contents){
            if (content.contains("</Content>")) {
                details.add(ImmutablePair.of("", content.replaceAll("\n", "").substring(0, content.lastIndexOf("</Content>")).replaceAll("<Content>", " ").replaceAll("</Content>", " ").replaceAll("\\s+", " ").trim()));
            }
        }
        return details;
    }

    public Pair<String,String> pathQuestionLabelAnswerOther(final String rootPath, final String element, final String otherElement) {
        return ImmutablePair.of(pathQuestionLabel(rootPath, element), pathAnswerOther(rootPath, element, otherElement));
    }

    public List<Pair<String, String>> prepareTestData(final String rootPath, final List<String> elements) {
        return elements.stream().map(e -> pathQuestionLabelAnswer(rootPath, e)).collect(Collectors.toList());
    }

    public List<String> convertListOfPairsToListOfString(final List<Pair<String, String>> details) {
        final List<String> newDetails = details.stream().filter(s -> testPair(s)).map(s -> buildQuestion(s.getLeft(), s.getRight())).collect(Collectors.toList());
        return newDetails;
    }

    private boolean testPair(final Pair<String, String> s) {
        return !(s.getLeft() == null || s.getRight() == null || s.getRight().isEmpty());
    }
}
