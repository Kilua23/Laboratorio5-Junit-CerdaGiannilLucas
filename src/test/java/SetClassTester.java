
import org.junit.jupiter.api.*;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@IndicativeSentencesGeneration(separator = "-->",generator = DisplayNameGenerator.Standard.class)
public class SetClassTester {

   private SetClass setClass = new SetClass();
   private TreeSet<Character> setA = setClass.getsetA();
   private TreeSet<Character> setB = setClass.getsetB();
   private TreeSet<Character> setC = setClass.getsetC();


   @BeforeEach
   @DisplayName("Conjuntos No Vacio")
   public void emptySetTest()
   {
       assertNotNull(setA);
       assertNotNull(setB);
       assertNotNull(setC);
   }

    @Test
    @DisplayName("Union de los conjuntos A y B")
    public void unionTest()
    {
        Set<Character> union_set = setClass.union(setA,setB);
        String string_set =String.valueOf(union_set);
        assertNotNull(string_set);
        assertEquals("[A, B, C, D, E]",string_set);
    }
    @Test
    @DisplayName("Interseccion de los conjuntos A y B")
    public void intersectionTest()
    {
        Set<Character> intersection_set = setClass.intersection(setA,setB);
        String sintersection_set =String.valueOf(intersection_set);
        assertNotNull(sintersection_set);
        assertNotEquals("[C, D, F]",sintersection_set, "Failed Intersection");
        assertEquals("[C, D]",sintersection_set, "Success Intersection");

    }
    @Test
    @DisplayName("Diferencia entre el conjunto A y B ( setA - setB) ")
    public void differenceTest()
    {
        assertAll("Elementos",
                () ->
                {
                    Set<Character> difference_set = setClass.union(setA, setB);
                    String sdifference_set = String.valueOf(difference_set);
                    assertNotNull(sdifference_set);

                    assertAll("sdifference_set",
                            () -> assertTrue(sdifference_set.startsWith("["), "True"),
                            () -> assertFalse(sdifference_set.startsWith("D"), "False"));

                });
    }

    @Test
    @DisplayName("Diferencia simetrica entre el conjunto A y B ( setA - setB) ")
    public void symmetricTest()
    {
        Set<Character> symmetric_set = setClass.union(setA,setB);
        String ssymmetric_set =String.valueOf(symmetric_set);
        assertNotEquals(null,ssymmetric_set);
    }

    @Test
    @DisplayName("Un conjunto es un subcojunto/superconjunto de otro conjunto")
    public void SubSuperSetTest()
    {
        assertFalse(setClass.isSubset(setA,setB),"Es setA un subconjunto de setB ? FALSE");
        assertFalse(setClass.isSuperset(setA,setB),"Es setA un superconjunto de setB ? FALSE");
        assertTrue(setClass.isSubset(setC,setA),"Es setC un subconjunto de setA ? TRUE");
        assertFalse(setClass.isSuperset(setC,setA),"Es setA un superconjunto de setB ? FALSE");
    }
}
