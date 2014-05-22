public class One extends OneInerface
{
    int chain, pocket;
    Stirng brand_name;

    void numberOfChains(int value)
    {
        chain = value;
    }

    void numberOfPackets(int value)
    {
        pocket = value;
    }

    void bagBrand(String name)
    {
        brand_name = name;
    }

    void BagDetails()
    {
        System.out.print("Brand Name: "+brand_name+"  Number of chains: "+chain+"  Number of Packets: "+ pocket);
        System.out.println();
    }
}
