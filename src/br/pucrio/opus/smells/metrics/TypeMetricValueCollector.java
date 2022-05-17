package br.pucrio.opus.smells.metrics;

import br.pucrio.opus.smells.metrics.calculators.*;

public class TypeMetricValueCollector extends MetricValueCollector {

	public TypeMetricValueCollector() {
		addCalculator(new TCCMetricValueCalculator());
		addCalculator(new PublicFieldCountCalculator());
		addCalculator(new ClassLOCCalculator());
		addCalculator(new OverrideRatioCalculator());
		addCalculator(new IsClassAbstract());
		addCalculator(new NOAMCalculator());
		addCalculator(new WMCCalculator());
		addCalculator(new WOCCalculator());
		addCalculator(new LCOM2Calculator());
		addCalculator(new LCOM3Calculator());
	}
}
