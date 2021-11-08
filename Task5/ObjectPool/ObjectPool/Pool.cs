using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ObjectPool
{
    public class Pool
    {
       
        private int _counter = 0;
        private int _maxSize = 5;

        private readonly List<Item> objectsAvailable = new List<Item>();
        private readonly List<Item> objectsNonAvailable = new List<Item>();

        public void SetMaxSize(int size)
        {
            _maxSize = size;
        }

        public Item GetObject()
        {
            if(objectsAvailable.Count > 0)
            {
                var obj = objectsAvailable.First();
                objectsAvailable.RemoveAt(0);
                objectsNonAvailable.Add(obj);
                Console.WriteLine("Object pulled.");
                _counter--;
                return obj;
            }
            else
            {
                Item obj = new Item();
                objectsNonAvailable.Add(obj);
                _counter++;
                Console.WriteLine("New object created and pulled.");
                return obj;
            }
        }

        public void ReturnObject(Item obj)
        {
            if (_counter < _maxSize)
            {
                objectsAvailable.Add(obj);
                _counter++;
                Console.WriteLine("Object returned.");
            }
            else
            {
                Console.WriteLine("Maximum number of objects has been reached.");
            }
        }
    }
}
