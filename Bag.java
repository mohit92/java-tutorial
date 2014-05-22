class Bag implements  BagInterface
{
    int chain, pocket;
    String brand_name;

    public void numberOfChains(int value)
    {
        chain = value;
    }

    public void numberOfPockets(int value)
    {
        pocket = value;
    }

   public  void bagBrand(String name)
    {
        brand_name = name;
    }

    public void BagDetails()
    {
        System.out.print("Brand Name: "+brand_name+"  Number of chains: "+chain+"  Number of Packets: "+ pocket);
        System.out.println();
    }


     public static void main(String [] args)
    {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();

        bag1.brand_name = "Case Werkz";
        bag1.chain = 4;
        bag1.pocket = 8;
        bag1.BagDetails();

        bag2.brand_name = "Puma";
        bag2.chain = 4;
        bag2.pocket = 5;
        bag2.BagDetails();
    }



}
