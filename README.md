##Data-driven testing

###Principal concept
The data-driven scripting technique builds on the structured scripting technique. The most
significant difference is how the test inputs are handled. The inputs are extracted from the scripts
and put into one or more separate files (typically called data files).
This means the main test script can be reused to implement a number of tests (rather than just a
single test). Typically the ‘reusable’ main test script is called a ‘control’ script. The control script
contains the sequence of instructions necessary to perform the tests but reads the input data from
a data file. One control test may be used for many tests but it is usually insufficient to automate a
wide range of tests. Thus, a number of control scripts will be required but that is only a fraction of
the number of tests that are automated.

###Pros
The cost of adding new automated tests can be significantly reduced by this scripting technique.
This technique is used to automate many variations of a useful test, giving deeper testing in a
specific area and may increase test coverage.
Having the tests ‘described’ by the data files means that Test Analysts can specify ‘automated’
tests simply by populating one or more data files. This gives Test Analysts more freedom to specify
automated tests without as much dependency on the Technical Test Analysts (who may be a
scarce resource).

###Cons
The need to manage data files and make sure they are readable by TAS is a disadvantage but can
be approached properly.
Also, important negative test cases may be missed. Negative tests are a combination of test
procedures and test data. In an approach targeting test data mainly, "negative test procedures"
may be missed.