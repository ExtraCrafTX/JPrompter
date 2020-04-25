package com.kaamiljasani.jprompter;

import java.util.function.Function;

public interface Prompter {

    public String prompt(String prompt);
    public String prompt(String prompt, Function<String, String> validator);
    public String prompt(String prompt, String def, Function<String, String> validator);
    public boolean yesOrNo(String prompt, boolean def);
    public boolean yesOrNo(String prompt, boolean def, String yes, String no);
    public String promptSemVer(String prompt) throws Exception;
    public int promptList(String prompt, boolean required, int def, String... options);
    public int promptList(String prompt, boolean required, int def, Object... options);
    public Spinner startSpinner(String text, int interval, String... frames);

    public interface Spinner {
        public void success(String text);
        public void error(String text);
    }

}