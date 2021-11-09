import java.util.Set;
import java.util.TreeSet;

public class SetClass {

    // UNION
    public  <T> Set<T> union(Set<T> setA, Set<T> setB)
    {
        Set<T> set = new TreeSet<T>(setA);
        set.addAll(setB);
        return set;
    }

    // INTERSECCION
    public  <T> Set<T> intersection(Set<T> setA, Set<T> setB)
    {
        Set<T> set = new TreeSet<T>();
        for (T e : setA)
            if (setB.contains(e))
                set.add(e);
        return set;
    }

    // DIFERENCIA (SET A - SET B )
    public  <T> Set<T> difference(Set<T> setA, Set<T> setB)
    {
        Set<T> set = new TreeSet<T>(setA);
        try {
            if (!set.isEmpty())
                set.removeAll(setB);
        }catch (NullPointerException e){  System.err.println("RemoveAll Exception"+e.getMessage());;}
        return set;
    }

    // DIFERENCIA SIMETRICA
    public  <T> Set<T> symmetricDifference(Set<T> setA, Set<T> setB)
    {
        Set<T> set1;
        Set<T> set2;

        set1 = this.union(setA, setB);
        set2 = this.intersection(setA, setB);
        return this.difference(set1, set2);
    }

    // SUBCONJUNTO
    public  <T> boolean isSubset(Set<T> setA, Set<T> setB)
    {
        return setB.containsAll(setA);
    }

    // SUPERCONJUNTO
    public  <T> boolean isSuperset(Set<T> setA, Set<T> setB)
    {
        return setA.containsAll(setB);
    }

    public <T> TreeSet<Character> getsetA()
    {
        TreeSet<Character> setA = new TreeSet<Character>();
        char c= ' ';
        for(int i=0;i<4;i++)
        {
            c = (char)('A' + i);
            setA.add(c);
        }
        return setA;
    }

    public <T> TreeSet<Character> getsetB()
    {
        TreeSet<Character> setB = new TreeSet<Character>();
        char c= ' ';
        for(int i=0;i<4;i++)
        {
            c= (char)('C' + i);
            setB.add(c);
        }
        return setB;
    }

    public <T> TreeSet<Character> getsetC()
    {
        TreeSet<Character> setC = this.getsetA();
        try {
            if (!setC.isEmpty())
                setC.remove('A');
        }catch (NullPointerException e)
        {
            System.err.println("Remove Exception"+e.getMessage());
        }

        return setC;
    }
}
