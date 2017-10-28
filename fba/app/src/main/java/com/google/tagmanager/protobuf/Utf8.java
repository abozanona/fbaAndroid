package com.google.tagmanager.protobuf;

final class Utf8 {
	public static final int COMPLETE = 0;
	public static final int MALFORMED = -1;

	private Utf8() {
	}

	private static int incompleteStateFor(int byte1) {
		if (byte1 > -12) {
			return MALFORMED;
		}
		return byte1;
	}

	private static int incompleteStateFor(int byte1, int byte2) {
		return (byte1 > -12 || byte2 > -65) ? MALFORMED : (byte2 << 8) ^ byte1;
	}

	private static int incompleteStateFor(int byte1, int byte2, int byte3) {
		return (byte1 > -12 || byte2 > -65 || byte3 > -65) ? MALFORMED : ((byte2 << 8) ^ byte1) ^ (byte3 << 16);
	}

	private static int incompleteStateFor(byte[] bytes, int index, int limit) {
		int byte1 = bytes[index - 1];
		switch((limit - index)) {
		case COMPLETE:
			return incompleteStateFor(byte1);
		case WireFormat.WIRETYPE_FIXED64:
			return incompleteStateFor(byte1, bytes[index]);
		case WireFormat.WIRETYPE_LENGTH_DELIMITED:
			return incompleteStateFor(byte1, bytes[index], bytes[index + 1]);
		}
		throw new AssertionError();
	}

	public static boolean isValidUtf8(byte[] bytes) {
		return isValidUtf8(bytes, COMPLETE, bytes.length);
	}

	public static boolean isValidUtf8(byte[] bytes, int index, int limit) {
		return partialIsValidUtf8(bytes, index, limit) == 0;
	}

	public static int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
		if (state != 0) {
			if (index >= limit) {
				return state;
			} else {
				int byte1 = (byte) state;
				int index_2;
				if (byte1 < (byte) -32) {
					if (byte1 >= (byte) -62) {
						index_2 = index + 1;
						if (bytes[index] > (byte) -65) {
							index = index_2;
						} else {
							index = index_2;
						}
					}
					return -1;
				} else if (byte1 < (byte) -16) {
					byte2 = (byte) ((state >> 8) ^ -1);
					if (byte2 == (byte) 0) {
						index = index + 1;
						byte2 = bytes[index];
						if (index >= limit) {
							index = index;
							return incompleteStateFor(byte1, byte2);
						}
					} else {
						index = index;
					}
					if (byte2 <= (byte) -65) {
						if (byte1 != (byte) -32 || byte2 >= (byte) -96) {
							if (byte1 != (byte) -19 || byte2 < (byte) -96) {
								index = index + 1;
								if (bytes[index] > (byte) -65) {
								}
							} else {
								index = index;
							}
						} else {
							index = index;
						}
					} else {
						index = index;
					}
					return -1;
				} else {
					byte2 = (byte) ((state >> 8) ^ -1);
					byte byte3 = (byte) 0;
					if (byte2 == (byte) 0) {
						index = index + 1;
						byte2 = bytes[index];
						if (index >= limit) {
							index = index;
							return incompleteStateFor(byte1, byte2);
						}
					} else {
						byte3 = (byte) (state >> 16);
						index = index;
					}
					if (byte3 == (byte) 0) {
						index = index + 1;
						byte3 = bytes[index];
						if (index >= limit) {
							return incompleteStateFor(byte1, (int)byte2, (int)byte3);
						} else {
							index = index;
						}
					}
					if (byte2 > (byte) -65 || (((byte1 << 28) + (byte2 + 112)) >> 30) != 0 || byte3 > (byte) -65) {
						index = index;
					} else {
						index = index + 1;
						if (bytes[index] > (byte) -65) {
						}
					}
					return -1;
				}
			}
		}
		return partialIsValidUtf8(bytes, index, limit);
	}

	/* JADX WARNING: inconsistent code */
	/*
	public static int partialIsValidUtf8(byte[] r1_bytes, int r2_index, int r3_limit) {
	L_0x0000:
		if (r2_index >= r3_limit) goto L_0x0009;
	L_0x0002:
		r0 = r1_bytes[r2_index];
		if (r0 < 0) goto L_0x0009;
	L_0x0006:
		r2_index++;
		goto L_0x0000;
	L_0x0009:
		if (r2_index < r3_limit) goto L_0x000d;
	L_0x000b:
		r0 = 0;
	L_0x000c:
		return r0;
	L_0x000d:
		r0 = partialIsValidUtf8NonAscii(r1, r2, r3);
		goto L_0x000c;
	}
	*/
	public static int partialIsValidUtf8(byte[] bytes, int index, int limit) {
		while (index < limit && bytes[index] >= (byte) 0) {
			index++;
		}
		return partialIsValidUtf8NonAscii(bytes, index, limit);
	}

	private static int partialIsValidUtf8NonAscii(byte[] bytes, int index, int limit) {
		int index_2 = index;
		while (index_2 < limit) {
			index = index_2 + 1;
			byte byte1 = bytes[index_2];
			if (byte1 < (byte) 0) {
				if (byte1 < (byte) -32) {
					if (index < limit) {
						if (byte1 >= (byte) -62) {
							index = index + 1;
							if (bytes[index] > (byte) -65) {
								index = index;
							}
						}
						return -1;
					}
					return byte1;
				} else if (byte1 < (byte) -16) {
					if (index >= limit - 1) {
						return incompleteStateFor(bytes, index, limit);
					} else {
						index = index + 1;
						byte2 = bytes[index];
						if (byte2 <= (byte) -65) {
							if (byte1 != (byte) -32 || byte2 >= (byte) -96) {
								if (byte1 != (byte) -19 || byte2 < (byte) -96) {
									index = index + 1;
									if (bytes[index] > (byte) -65) {
									}
									index_2 = index;
								} else {
									index = index;
								}
							} else {
								index = index;
							}
						} else {
							index = index;
						}
						return -1;
					}
				} else if (index >= limit - 2) {
					return incompleteStateFor(bytes, index, limit);
				} else {
					index = index + 1;
					byte2 = bytes[index];
					if (byte2 > (byte) -65 || (((byte1 << 28) + (byte2 + 112)) >> 30) != 0) {
						index = index;
					} else {
						index = index + 1;
						if (bytes[index] <= (byte) -65) {
							index = index + 1;
							if (bytes[index] > (byte) -65) {
								index = index;
							}
						}
					}
					return -1;
				}
				index = index;
				index_2 = index;
			} else {
				index_2 = index;
			}
		}
		index = index_2;
		return COMPLETE;
	}
}
