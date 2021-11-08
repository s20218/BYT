using System;

namespace ObjectPool
{
    class Program
    {
        public static void Main(string[] args)
        {
            var pool = new Pool();

            pool.SetMaxSize(2);

            var obj1 = pool.GetObject();
            var obj2 = pool.GetObject();
            var obj3 = pool.GetObject();

            pool.ReturnObject(obj2);
        }
    }
}
