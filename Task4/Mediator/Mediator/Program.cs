using System;

namespace Mediator
{
    class Program
    {
        static void Main(string[] args)
        {
            Cashier cashier = new();
            Customer customer = new();

            new CheckoutMediator(cashier, customer);

            cashier.Send("Card or cash?");

            customer.Send("Card.");
        }
    }
}
