package com.kaamiljasani.jprompter;

import java.util.function.Function;

public interface Prompter {

    /**
     * Prompt the user for a string input.
     * <br><br>
     * Blocks until a value is entered.
     * 
     * @param prompt  The message to prompt the user with
     * @return The value input by the user
     */
    public String prompt(String prompt);

    /**
     * Prompt the user for a string input and validate the input.
     * <br><br>
     * Blocks until a valid value is entered.
     * <br><br>
     * The validator should return a String for the error message if the
     * given input is not valid, or return null if the input is valid.
     * 
     * @param prompt  The message to prompt the user with
     * @param validator  A function that returns the error message if 
     * invalid, or null if valid
     * @return The value input by the user
     */
    public String prompt(String prompt, Function<String, String> validator);

    /**
     * Prompt the user for a string input with the given default, and
     * validate the input.
     * <br><br>
     * Blocks until a valid value is entered.
     * <br><br>
     * The validator should return a String for the error message if the
     * given input is not valid, or return null if the input is valid.
     * 
     * @param prompt  The message to prompt the user with
     * @param def  The default value to start with
     * @param validator  A function that returns the error message if 
     * invalid, or null if valid
     * @return The value input by the user
     */
    public String prompt(String prompt, String def, Function<String, String> validator);

    /**
     * Prompt the user for a yes or no (boolean) input with the given default.
     * <br><br>
     * Blocks until a valid value is selected.
     * 
     * @param prompt  The message to prompt the user with
     * @param def  The default value to start with
     * @return <code>true</code> if the user selected Yes, <code>false</code> if no
     */
    public boolean yesOrNo(String prompt, boolean def);

    /**
     * Prompt the user for a yes or no (boolean) input with the given default
     * and with the given strings for yes and no.
     * <br><br>
     * Blocks until a valid value is selected.
     * 
     * @param prompt  The message to prompt the user with
     * @param def  The default value to start with
     * @param yes  The text to use instead of 'Yes'
     * @param no  The text to use instead of 'No'
     * @return <code>true</code> if the user selected Yes, <code>false</code> if no
     */
    public boolean yesOrNo(String prompt, boolean def, String yes, String no);

    /**
     * Prompt the user for a version in <a href="https://semver.org/">SemVer</a> format.
     * <br><br>
     * Blocks until a valid value is input.
     * 
     * @param prompt  The message to prompt the user with
     * @return The valid SemVer string input by the user
     */
    public String promptSemVer(String prompt);

    /**
     * Prompt the user to select a value from the given list.
     * <br><br>
     * Blocks until a value is selected, or no value is selected if not required.
     * 
     * @param prompt  The message to prompt the user with
     * @param required  Whether a value is required to be selected
     * @param def  Index of the value to be selected by default
     * @param options  Array of options to be displayed
     * @return The index of the selected value, or <code>-1</code> if a value
     * was not selected
     */
    public int promptList(String prompt, boolean required, int def, String... options);

    /**
     * Prompt the user to select a value from the given list. The <code>toString</code>
     * method of each object is invoked to get the values to display to the user.
     * <br><br>
     * Blocks until a value is selected, or no value is selected if not required.
     * 
     * @param prompt  The message to prompt the user with
     * @param required  Whether a value is required to be selected
     * @param def  Index of the value to be selected by default
     * @param options  Array of options to be displayed
     * @return The index of the selected value, or <code>-1</code> if a value
     * was not selected
     */
    public int promptList(String prompt, boolean required, int def, Object... options);

    /**
     * Starts and returns a spinner with the given text.
     * 
     * @param text  The text to display with the spinner
     * @return The {@link Spinner} created by this call
     */
    public Spinner startSpinner(String text);

    public interface Spinner {

        /**
         * Stops the spinner with a success message. The Spinner should
         * not be used after calling this method.
         * @param message  The success message
         */
        public void success(String message);

        /**
         * Stops the spinner with an error message. The Spinner should
         * not be used after calling this method.
         * @param message  The error message
         */
        public void error(String message);
    }

}