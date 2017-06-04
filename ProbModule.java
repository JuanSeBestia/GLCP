public class ProbModule {
	int[] sumRules;
	int[] sumDervation;
	boolean bAdd = true;

	public ProbModule(int i) {
		sumRules = new int[i];
		sumDervation = new int[30 * i];
	}

	public float probDerivation(int rule, int derivation) {
		if (rule > 0 && derivation > 0)
			return sumDervation[derivation] / sumRules[rule];
		else
			return 0;
	}

	public float addDerivation(int rule, int derivation) {
		if (bAdd && rule > 0 && derivation > 0 ) {
			sumRules[rule]++;
			sumDervation[derivation]++;

		}
		return probDerivation(rule, derivation);
	}

	public String toStringPositive() {
		StringBuilder sb = new StringBuilder();
		sb.append("#######RESUME########\n");
		for (int i = 0; i < sumDervation.length; i++) {
			if (sumDervation[i] > 0)
				sb.append("Deriviation [" + i + "]: " + sumDervation[i] + "\n");
		}
		for (int i = 0; i < sumRules.length; i++) {
			if (sumRules[i] > 0)
				sb.append("Rule [" + i + "]: " + sumRules[i] + "\n");
		}

		return sb.toString();
	}

	public void setCalculate() {
		bAdd = false;
		
	}

}
