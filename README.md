##Structured scripting
###Principal concept
The major difference between the structured scripting technique and the linear scripting technique
is the introduction of a script library. This contains reusable scripts that perform sequences of
instructions that are commonly required across a number of tests. Good examples of such scripts
are those that interface, e.g., to the operations of SUT interfaces.

###Pros
Benefits of this approach include a significant reduction in the maintenance changes required and
the reduced cost of automating new tests (because they can use scripts that already exist rather
than having to create them all from scratch).
The advantages of structured scripting are largely attained through the reuse of scripts. More tests
can be automated without having to create the volume of scripts that a linear scripting approach
would require. This has a direct impact on the build and maintenance costs. The second and
subsequent tests will not take as much effort to automate because some of the scripts created to
implement the first test can be reused again.

###Cons
The initial effort to create the shared scripts can be seen as a disadvantage but this initial
investment should pay big dividends if approached properly. Programming skills will be required to
create all the scripts as simple recording alone will not be sufficient. The script library must be well
managed, i.e., the scripts should be documented and it should be easy for Technical Test Analysts
to find the required scripts (so a sensible naming convention will help here).