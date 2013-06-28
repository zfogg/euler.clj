package euler.primes;

import java.util.ArrayList;
import java.util.Iterator;


public class PrimeSieve implements Iterable<Long> {
    private Long prime;
    public Long max;
    private ArrayList<Boolean> sieve;

    public PrimeSieve(Long max) {
        this(max, 2L, initSieve(max));
    }

    private PrimeSieve(Long max, Long p, ArrayList<Boolean> sieve) {
        this.sieve = sieve;
        this.max = max;
        prime = nextPrime(p);
    }

    private static ArrayList<Boolean> initSieve(Long max) {
        ArrayList<Boolean> sieve = new ArrayList<Boolean>(){{
            // Primality values for {0, 1}.
            add(false); add(false);
        }};
        for (long i = 2L; i < max; i++)
            sieve.add(true);
        return sieve;
    }

    private Long nextPrime(Long p) {
        for (long i = p; i < this.max; i++)
            if (sieve.get((int) (i+0)))
                return i;
        return this.max;
    }

    private PrimeSieve next() {
        if (prime < this.max) {
            markMultiples(this.prime);
            return new PrimeSieve(this.max, this.prime, sieve);
        }
        return null;
    }

    private void markMultiples(Long n) {
        for (Long i = 1L, j = n; j < this.max; i++, j = i*n)
            sieve.set((int) (j+0), false);
    }

    public Iterator<Long> iterator() {
        final PrimeSieve that = this;
        return new Iterator<Long>() {
            private PrimeSieve cur = that,
                    next;

            public void remove() { throw new UnsupportedOperationException(); }
            public boolean hasNext() {
                next = cur.next();
                return next != null;
            }
            public Long next() {
                Long r = cur.prime;
                cur = next;
                return r;
            }
        };
    }
}
