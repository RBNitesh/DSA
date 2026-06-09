// O(N*logN) preprocessing
// finds min or max in a range in O(1)
class SparseTable{
    int[][] m1, m2;
    int[] log;
    int LOG;
	public SparseTable(int[] a, int n){
        log = new int[n+1];
		log[1] = 0;
		for(int i = 2; i <= n; i++) {
		    log[i] = log[i/2]+1;
		}

        LOG = log[n]+1;
        m1 = new int[n][LOG];
		m2 = new int[n][LOG];

		for(int i = 0; i < n; i++) {
			m1[i][0] = a[i];
            m2[i][0] = a[i];
		}

		// 2. preprocessing, O(N*log(N))
		for(int k = 1; k < LOG; k++) {
			for(int i = 0; i + (1 << k) - 1 < n; i++) {
				m1[i][k] = Math.min(m1[i][k-1], m1[i+(1<<(k-1))][k-1]);
                m2[i][k] = Math.max(m2[i][k-1], m2[i+(1<<(k-1))][k-1]);
			}
		}
	}

    // O(1) 
	int query(int L, int R) { // O(1)
		int length = R - L + 1;
		int k = log[length];
		return Math.max(m2[L][k], m2[R-(1<<k)+1][k]) - Math.min(m1[L][k], m1[R-(1<<k)+1][k]);
	}
}