package com.google.tagmanager;

interface ValueBuilder {
	public MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension();

	public ValueBuilder getListItem(int r1i);

	public ValueBuilder getMapKey(int r1i);

	public ValueBuilder getMapValue(int r1i);

	public ValueBuilder getTemplateToken(int r1i);
}
