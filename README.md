# diabetes-population-sim
Java implementation of type-1 diabetes spread over generations

# License
Copyright (c) 2014 Eduardo Santos Medeiros de Vasconcelos

Permission is hereby granted, free of charge, to any person obtaining 
a copy of this software and associated documentation files (the 
“Software”), to deal in the Software without restriction, including 
without limitation the rights to use, copy, modify, merge, publish, 
distribute, sublicense, and/or sell copies of the Software, and to 
permit persons to whom the Software is furnished to do so, subject to 
the following conditions:

The above copyright notice and this permission notice shall be included 
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS 
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY 
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

# Author
Eduardo S. M. de Vasconcelos | vasconce_at_tcd_dot_ie
Trinity College Dublin School of Engineering

# Quick guide
This is a Java program to perform a simulation on type-1 diabetes spread
on a population over generations.

It uses the the constants defined at util.Constants (real world data) to
perform the simulation. The inheritance algorithm is implemented at
util.Odds.

After the simulation is finished, results are exported to a spreadsheet
whose path is specified at diabetesinheritance.DiabetesInheritance (line 80).

Default constants defined at util.Constants are:

  1. POPULATION_SIZE
    * specifies the initial population size
  2. DIABETICS
    * specifies the initial percentage of diabetics
  3. ODDS_FATHER_ONLY
    * odds of inheritance if only the father has the disease
  4. ODDS_MOTHER_ONLY_LESS_THAN_TWENTY_FIVE
    * odds of inheritance if only the mother has the disease and is less than 25 years old
  5. ODDS_MOTHER_ONLY_NOT_LESS_THAN_TWENTY_FIVE
    * odds of inheritance if only the mother has the disease and is more than 25 years old
  6. WOMEN_S_FERTILITY
    * women's fertility
  7. MOMS_UNDER_AGE_25
    * proportion of mothers under the age of 25
  8. GENERATIONS
    * number of generations to simulate
  9. EXCHANGE_FACTOR
    * population exchange factor

For further detail please refer to file "Type-1-Diabetes-Eduardo-Vasconcelos.pdf"
