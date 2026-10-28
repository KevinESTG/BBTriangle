package triangle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testes de caixa preta para a classe Triangle.
 * Casos derivados de Equivalence Class Partitioning (ECP) e Boundary Value Analysis (BVA).
 * Os resultados esperados baseiam-se na especificacao (Javadoc de classify()), nao no codigo.
 */
public class TriangleTest {

    // ---------- ECP ----------

    @Test
    void testImpossible_ECP1() {
        // 1000,10,10 viola a desigualdade triangular -> deve ser impossible
        Triangle t = new Triangle(1000, 10, 10);
        assertEquals("impossible", t.classify(), "TC01: 1000,10,10 deve ser impossible");
    }

    @Test
    void testEquilateral_ECP3() {
        Triangle t = new Triangle(3, 3, 3);
        assertEquals("equilateral", t.classify(), "TC02: 3,3,3 deve ser equilateral");
    }

    @Test
    void testRightAngled_ECP5() {
        // 5,4,3 -> 5^2 = 4^2 + 3^2
        Triangle t = new Triangle(5, 4, 3);
        assertEquals("right-angled", t.classify(), "TC03: 5,4,3 deve ser right-angled");
    }

    @Test
    void testScalene_ECP7() {
        // 4,6,7 -> lados diferentes, nao retangulo
        Triangle t = new Triangle(4, 6, 7);
        assertEquals("scalene", t.classify(), "TC04: 4,6,7 deve ser scalene");
    }

    @Test
    void testIsosceles_ECP9() {
        Triangle t = new Triangle(5, 5, 8);
        assertEquals("isosceles", t.classify(), "TC05: 5,5,8 deve ser isosceles");
    }

    @Test
    void testIsosceles_ECP9_posicao() {
        // lados iguais em s1 e s3 (nao adjacentes)
        Triangle t = new Triangle(5, 8, 5);
        assertEquals("isosceles", t.classify(), "TC06: 5,8,5 deve ser isosceles");
    }

    // ---------- BVA (dominio [0, MaxInt]) ----------

    @Test
    void testBVA1() {
        Triangle t = new Triangle(0, 0, 0);
        assertEquals("impossible", t.classify(), "TC07: 0,0,0 deve ser impossible");
    }

    @Test
    void testBVA2() {
        Triangle t = new Triangle(0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals("impossible", t.classify(), "TC08: 0,Max,Max deve ser impossible");
    }

    @Test
    void testBVA3() {
        Triangle t = new Triangle(0, 0, Integer.MAX_VALUE);
        assertEquals("impossible", t.classify(), "TC09: 0,0,Max deve ser impossible");
    }

    @Test
    void testBVA4() {
        Triangle t = new Triangle(0, Integer.MAX_VALUE, 0);
        assertEquals("impossible", t.classify(), "TC10: 0,Max,0 deve ser impossible");
    }

    @Test
    void testBVA5() {
        Triangle t = new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        assertEquals("impossible", t.classify(), "TC11: Max,Max,0 deve ser impossible");
    }

    @Test
    void testBVA6() {
        Triangle t = new Triangle(Integer.MAX_VALUE, 0, 0);
        assertEquals("impossible", t.classify(), "TC12: Max,0,0 deve ser impossible");
    }

    @Test
    void testBVA7() {
        Triangle t = new Triangle(Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        assertEquals("impossible", t.classify(), "TC13: Max,0,Max deve ser impossible");
    }

    @Test
    void testBVA8() {
        Triangle t = new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals("equilateral", t.classify(), "TC14: Max,Max,Max deve ser equilateral");
    }
}