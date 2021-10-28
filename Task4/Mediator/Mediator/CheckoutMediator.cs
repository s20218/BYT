using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mediator
{
    public class CheckoutMediator : ICheckoutMediator
    {
        public Cashier Cashier { get; set; }

        public Customer Customer { get; set; }

        public CheckoutMediator(Cashier cashier, Customer customer)
        {
            Cashier = cashier;
            Cashier.SetMediator(this);
            Customer = customer;
            Customer.SetMediator(this);
        }

        public void SendMessage(Person caller, string msg)
        {
            if (caller == Cashier)
            {
                Customer.Receive(msg);
            }
            else
            {
                Cashier.Receive(msg);
            }
        }
    }
}
