package BASE;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Miguel Nobrega
 */

/*
Exercise 20 - Multistate Sales Tax Calculator
More complex programs may have decisions nested in other decisions, so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.

Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.

Challenges
Add support for your state and county.
Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
Allow the user to also enter the state’s full name in upper, lower, or mixed case.
Implement the program using data structures to avoid nested if statements.
 */


public class taxCalc
{
    private int order;
    private String state;
    private String county;

    private final double TAX_WI = 0.05;
    private final double TAX_EAUCLAIRE = 0.055;
    private final double TAX_DUNN = 0.054;
    private final double TAX_IL = 0.08;

    public int getOrder()
    {
        return order;
    }

    public void setOrder(int order)
    {
        this.order = order;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCounty()
    {
        return county;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public double returnTax()
    {
        if(state.equalsIgnoreCase("wi") || state.equalsIgnoreCase("Wisconsin"))
        {
            if(county.equalsIgnoreCase("Eau Claire"))
            {
                return order * TAX_EAUCLAIRE;
            }
            else if(county.equalsIgnoreCase("Dunn County"))
            {
                return order * TAX_DUNN;
            }
            else
            {
                return order * TAX_WI;
            }
        }
        else if(state.equalsIgnoreCase("il") || state.equalsIgnoreCase("Illinois"))
        {
            return order * TAX_IL;
        }

        return 0;
    }

    public double returnTotal()
    {
        return order + (returnTax());
    }
}
