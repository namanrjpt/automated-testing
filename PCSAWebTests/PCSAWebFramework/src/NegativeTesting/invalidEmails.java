package NegativeTesting;

/**
 * Created by naman on 28/6/17.
 */
public class invalidEmails {
    public static String invalidEmailCases[] = {"email", // '@' is important
                                                "email@",
                                                "email@something", // '.com' part is missing
                                                ".email@something.com", //can't start with a period
                                                "email.@something.com",
                                                "email@.something.com",
                                                "email@something..com",
                                                "email@something.com.",
                                                "em@il@something.com",
                                                "emai(l@something.com",
                                                "emai[l@something.com"};
}
