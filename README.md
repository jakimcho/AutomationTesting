##Keyword-driven testing
###Principal concept
The keyword-driven scripting technique builds on the data-driven scripting technique. There are
two main differences: (1) the data files are now called ‘test definition’ files or something similar (e.g.,
action word files); and (2) there is only one control script.
A test definition file contains a description of the tests in a way that should be easier for Test
Analysts to understand (easier than the equivalent data file). It will usually contain data as does the
data files but keyword files also contain high level instructions (the keywords, or ‘action words’).
The keywords should be chosen to be meaningful to the Test Analyst, the tests being described
and the application being tested. These are mostly (but not exclusively) used to represent high-
level business interactions with a system (e.g., “place order”). Each keyword represents a number
of detailed interactions with the system under test. Sequences of keywords (including the relevant
test data) are used to specify the test cases. Special keywords can be used for verification steps,
or keywords can contain both the actions and the verification steps.
The scope of responsibility for Test Analysts includes creating and maintaining the keyword files.
This means that once the supporting scripts are implemented, Test Analysts can add ‘automated’
tests simply by specifying them in a keyword file (as with data-driven scripting).

###Pros
Once the controlling script and supporting scripts for the keywords have been written, the cost of
adding new automated tests will be much reduced by this scripting technique.
Having the tests ‘described’ by the keyword files means that Test Analysts can specify ‘automated’
tests simply by describing the tests using the keywords and associated data. This gives Test
Analysts more freedom to specify automated tests without as much dependency on the Technical
Test Analysts (who may be a scarce resource). The benefit of the keyword-driven approach over
the data-driven approach in this regard is the use of the keywords. Each keyword should represent
a sequence of detailed actions that produce some meaningful result. For example, ‘create account’,
‘place order’, ‘check order status’ are all possible actions for an online shopping application that
each involve a number of detailed steps. When one Test Analyst describes a system test to another
Test Analyst, they are likely to speak in terms of these high level actions, not the detailed steps.
The aim of the keyword-driven approach then is to implement these high level actions and allow
tests to be defined in terms of the high level actions without reference to the detailed steps.
These test cases are easier to maintain, read and write as the complexity can be hidden in the
keywords (or in the libraries, in case of a structured scripting approach). The keywords can offer
an abstraction from the complexities of the interfaces of the SUT.

###Cons
Implementing the keywords remains a big task for test automation engineers, particularly if using a
tool that offers no support for this scripting technique. For small systems it may be too much
overhead to implement and the costs would outweigh the benefits.
Care needs to be taken to ensure that the correct keywords are implemented. Good keywords will
be used often with many different tests whereas poor keywords are likely to be used just once or
only a few times.