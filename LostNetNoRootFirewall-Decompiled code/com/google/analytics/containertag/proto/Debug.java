package com.google.analytics.containertag.proto;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Debug {

    public interface DataLayerEventEvaluationInfoOrBuilder extends MessageLiteOrBuilder {
        ResolvedFunctionCall getResults(int i);

        int getResultsCount();

        List getResultsList();

        RuleEvaluationStepInfo getRulesEvaluation();

        boolean hasRulesEvaluation();
    }

    public final class DataLayerEventEvaluationInfo extends GeneratedMessageLite implements DataLayerEventEvaluationInfoOrBuilder {
        public static Parser PARSER = new C0151b();
        public static final int RESULTS_FIELD_NUMBER = 2;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final DataLayerEventEvaluationInfo defaultInstance = new DataLayerEventEvaluationInfo(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List results_;
        private RuleEvaluationStepInfo rulesEvaluation_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements DataLayerEventEvaluationInfoOrBuilder {
            private int bitField0_;
            private List results_ = Collections.emptyList();
            private RuleEvaluationStepInfo rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureResultsIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.results_ = new ArrayList(this.results_);
                    this.bitField0_ |= 2;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAllResults(Iterable iterable) {
                ensureResultsIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.results_);
                return this;
            }

            public Builder addResults(int i, Builder builder) {
                ensureResultsIsMutable();
                this.results_.add(i, builder.build());
                return this;
            }

            public Builder addResults(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureResultsIsMutable();
                this.results_.add(i, resolvedFunctionCall);
                return this;
            }

            public Builder addResults(Builder builder) {
                ensureResultsIsMutable();
                this.results_.add(builder.build());
                return this;
            }

            public Builder addResults(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureResultsIsMutable();
                this.results_.add(resolvedFunctionCall);
                return this;
            }

            public DataLayerEventEvaluationInfo build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public DataLayerEventEvaluationInfo buildPartial() {
                int i = 1;
                DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo = new DataLayerEventEvaluationInfo((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                dataLayerEventEvaluationInfo.rulesEvaluation_ = this.rulesEvaluation_;
                if ((this.bitField0_ & 2) == 2) {
                    this.results_ = Collections.unmodifiableList(this.results_);
                    this.bitField0_ &= -3;
                }
                dataLayerEventEvaluationInfo.results_ = this.results_;
                dataLayerEventEvaluationInfo.bitField0_ = i;
                return dataLayerEventEvaluationInfo;
            }

            public Builder clear() {
                super.clear();
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.bitField0_ &= -2;
                this.results_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearResults() {
                this.results_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearRulesEvaluation() {
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public DataLayerEventEvaluationInfo getDefaultInstanceForType() {
                return DataLayerEventEvaluationInfo.getDefaultInstance();
            }

            public ResolvedFunctionCall getResults(int i) {
                return (ResolvedFunctionCall) this.results_.get(i);
            }

            public int getResultsCount() {
                return this.results_.size();
            }

            public List getResultsList() {
                return Collections.unmodifiableList(this.results_);
            }

            public RuleEvaluationStepInfo getRulesEvaluation() {
                return this.rulesEvaluation_;
            }

            public boolean hasRulesEvaluation() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean isInitialized() {
                if (hasRulesEvaluation() && !getRulesEvaluation().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getResultsCount(); i++) {
                    if (!getResults(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo) {
                if (dataLayerEventEvaluationInfo != DataLayerEventEvaluationInfo.getDefaultInstance()) {
                    if (dataLayerEventEvaluationInfo.hasRulesEvaluation()) {
                        mergeRulesEvaluation(dataLayerEventEvaluationInfo.getRulesEvaluation());
                    }
                    if (!dataLayerEventEvaluationInfo.results_.isEmpty()) {
                        if (this.results_.isEmpty()) {
                            this.results_ = dataLayerEventEvaluationInfo.results_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureResultsIsMutable();
                            this.results_.addAll(dataLayerEventEvaluationInfo.results_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(dataLayerEventEvaluationInfo.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo;
                DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo2;
                try {
                    dataLayerEventEvaluationInfo2 = (DataLayerEventEvaluationInfo) DataLayerEventEvaluationInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (dataLayerEventEvaluationInfo2 != null) {
                        mergeFrom(dataLayerEventEvaluationInfo2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    dataLayerEventEvaluationInfo2 = (DataLayerEventEvaluationInfo) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    dataLayerEventEvaluationInfo = dataLayerEventEvaluationInfo2;
                    th = th3;
                }
                if (dataLayerEventEvaluationInfo != null) {
                    mergeFrom(dataLayerEventEvaluationInfo);
                }
                throw th;
            }

            public Builder mergeRulesEvaluation(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
                if ((this.bitField0_ & 1) != 1 || this.rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance()) {
                    this.rulesEvaluation_ = ruleEvaluationStepInfo;
                } else {
                    this.rulesEvaluation_ = RuleEvaluationStepInfo.newBuilder(this.rulesEvaluation_).mergeFrom(ruleEvaluationStepInfo).buildPartial();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder removeResults(int i) {
                ensureResultsIsMutable();
                this.results_.remove(i);
                return this;
            }

            public Builder setResults(int i, Builder builder) {
                ensureResultsIsMutable();
                this.results_.set(i, builder.build());
                return this;
            }

            public Builder setResults(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureResultsIsMutable();
                this.results_.set(i, resolvedFunctionCall);
                return this;
            }

            public Builder setRulesEvaluation(Builder builder) {
                this.rulesEvaluation_ = builder.build();
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setRulesEvaluation(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
                if (ruleEvaluationStepInfo == null) {
                    throw new NullPointerException();
                }
                this.rulesEvaluation_ = ruleEvaluationStepInfo;
                this.bitField0_ |= 1;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private DataLayerEventEvaluationInfo(com.google.tagmanager.protobuf.CodedInputStream r10, com.google.tagmanager.protobuf.ExtensionRegistryLite r11) {
            /*
            r9 = this;
            r2 = 0;
            r0 = -1;
            r7 = 2;
            r1 = 1;
            r9.<init>();
            r9.memoizedIsInitialized = r0;
            r9.memoizedSerializedSize = r0;
            r9.initFields();
            r5 = com.google.tagmanager.protobuf.ByteString.newOutput();
            r6 = com.google.tagmanager.protobuf.CodedOutputStream.newInstance(r5);
            r3 = r2;
        L_0x0017:
            if (r2 != 0) goto L_0x0078;
        L_0x0019:
            r0 = r10.readTag();	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            switch(r0) {
                case 0: goto L_0x002b;
                case 10: goto L_0x002e;
                case 18: goto L_0x005c;
                default: goto L_0x0020;
            };	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
        L_0x0020:
            r0 = r9.parseUnknownField(r10, r6, r11, r0);	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            if (r0 != 0) goto L_0x00f2;
        L_0x0026:
            r0 = r1;
            r2 = r3;
        L_0x0028:
            r3 = r2;
            r2 = r0;
            goto L_0x0017;
        L_0x002b:
            r0 = r1;
            r2 = r3;
            goto L_0x0028;
        L_0x002e:
            r0 = 0;
            r4 = r9.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r4 = r4 & 1;
            if (r4 != r1) goto L_0x00ef;
        L_0x0035:
            r0 = r9.rulesEvaluation_;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r0 = r0.toBuilder();	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r4 = r0;
        L_0x003c:
            r0 = com.google.analytics.containertag.proto.Debug.RuleEvaluationStepInfo.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r0 = r10.readMessage(r0, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r0 = (com.google.analytics.containertag.proto.Debug.RuleEvaluationStepInfo) r0;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r9.rulesEvaluation_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            if (r4 == 0) goto L_0x0053;
        L_0x0048:
            r0 = r9.rulesEvaluation_;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r4.mergeFrom(r0);	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r0 = r4.buildPartial();	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r9.rulesEvaluation_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
        L_0x0053:
            r0 = r9.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r0 = r0 | 1;
            r9.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r0 = r2;
            r2 = r3;
            goto L_0x0028;
        L_0x005c:
            r0 = r3 & 2;
            if (r0 == r7) goto L_0x00ec;
        L_0x0060:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r9.results_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00a1, IOException -> 0x00c1 }
            r0 = r3 | 2;
        L_0x0069:
            r3 = r9.results_;	 Catch:{ InvalidProtocolBufferException -> 0x00e8, IOException -> 0x00e4, all -> 0x00e0 }
            r4 = com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x00e8, IOException -> 0x00e4, all -> 0x00e0 }
            r4 = r10.readMessage(r4, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00e8, IOException -> 0x00e4, all -> 0x00e0 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x00e8, IOException -> 0x00e4, all -> 0x00e0 }
            r8 = r2;
            r2 = r0;
            r0 = r8;
            goto L_0x0028;
        L_0x0078:
            r0 = r3 & 2;
            if (r0 != r7) goto L_0x0084;
        L_0x007c:
            r0 = r9.results_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r9.results_ = r0;
        L_0x0084:
            r6.flush();	 Catch:{ IOException -> 0x0091, all -> 0x0099 }
            r0 = r5.toByteString();
            r9.unknownFields = r0;
        L_0x008d:
            r9.makeExtensionsImmutable();
            return;
        L_0x0091:
            r0 = move-exception;
            r0 = r5.toByteString();
            r9.unknownFields = r0;
            goto L_0x008d;
        L_0x0099:
            r0 = move-exception;
            r1 = r5.toByteString();
            r9.unknownFields = r1;
            throw r0;
        L_0x00a1:
            r0 = move-exception;
        L_0x00a2:
            r0 = r0.setUnfinishedMessage(r9);	 Catch:{ all -> 0x00a7 }
            throw r0;	 Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r0 = move-exception;
        L_0x00a8:
            r1 = r3 & 2;
            if (r1 != r7) goto L_0x00b4;
        L_0x00ac:
            r1 = r9.results_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r9.results_ = r1;
        L_0x00b4:
            r6.flush();	 Catch:{ IOException -> 0x00d0, all -> 0x00d8 }
            r1 = r5.toByteString();
            r9.unknownFields = r1;
        L_0x00bd:
            r9.makeExtensionsImmutable();
            throw r0;
        L_0x00c1:
            r0 = move-exception;
        L_0x00c2:
            r1 = new com.google.tagmanager.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x00a7 }
            r0 = r0.getMessage();	 Catch:{ all -> 0x00a7 }
            r1.<init>(r0);	 Catch:{ all -> 0x00a7 }
            r0 = r1.setUnfinishedMessage(r9);	 Catch:{ all -> 0x00a7 }
            throw r0;	 Catch:{ all -> 0x00a7 }
        L_0x00d0:
            r1 = move-exception;
            r1 = r5.toByteString();
            r9.unknownFields = r1;
            goto L_0x00bd;
        L_0x00d8:
            r0 = move-exception;
            r1 = r5.toByteString();
            r9.unknownFields = r1;
            throw r0;
        L_0x00e0:
            r1 = move-exception;
            r3 = r0;
            r0 = r1;
            goto L_0x00a8;
        L_0x00e4:
            r1 = move-exception;
            r3 = r0;
            r0 = r1;
            goto L_0x00c2;
        L_0x00e8:
            r1 = move-exception;
            r3 = r0;
            r0 = r1;
            goto L_0x00a2;
        L_0x00ec:
            r0 = r3;
            goto L_0x0069;
        L_0x00ef:
            r4 = r0;
            goto L_0x003c;
        L_0x00f2:
            r0 = r2;
            r2 = r3;
            goto L_0x0028;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.containertag.proto.Debug.DataLayerEventEvaluationInfo.<init>(com.google.tagmanager.protobuf.CodedInputStream, com.google.tagmanager.protobuf.ExtensionRegistryLite):void");
        }

        private DataLayerEventEvaluationInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DataLayerEventEvaluationInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static DataLayerEventEvaluationInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            this.results_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo) {
            return newBuilder().mergeFrom(dataLayerEventEvaluationInfo);
        }

        public static DataLayerEventEvaluationInfo parseDelimitedFrom(InputStream inputStream) {
            return (DataLayerEventEvaluationInfo) PARSER.parseDelimitedFrom(inputStream);
        }

        public static DataLayerEventEvaluationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DataLayerEventEvaluationInfo) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static DataLayerEventEvaluationInfo parseFrom(ByteString byteString) {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(byteString);
        }

        public static DataLayerEventEvaluationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DataLayerEventEvaluationInfo parseFrom(CodedInputStream codedInputStream) {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(codedInputStream);
        }

        public static DataLayerEventEvaluationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static DataLayerEventEvaluationInfo parseFrom(InputStream inputStream) {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(inputStream);
        }

        public static DataLayerEventEvaluationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static DataLayerEventEvaluationInfo parseFrom(byte[] bArr) {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(bArr);
        }

        public static DataLayerEventEvaluationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DataLayerEventEvaluationInfo)) {
                return super.equals(obj);
            }
            DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo = (DataLayerEventEvaluationInfo) obj;
            boolean z = hasRulesEvaluation() == dataLayerEventEvaluationInfo.hasRulesEvaluation();
            if (hasRulesEvaluation()) {
                z = z && getRulesEvaluation().equals(dataLayerEventEvaluationInfo.getRulesEvaluation());
            }
            return z && getResultsList().equals(dataLayerEventEvaluationInfo.getResultsList());
        }

        public DataLayerEventEvaluationInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedFunctionCall getResults(int i) {
            return (ResolvedFunctionCall) this.results_.get(i);
        }

        public int getResultsCount() {
            return this.results_.size();
        }

        public List getResultsList() {
            return this.results_;
        }

        public ResolvedFunctionCallOrBuilder getResultsOrBuilder(int i) {
            return (ResolvedFunctionCallOrBuilder) this.results_.get(i);
        }

        public List getResultsOrBuilderList() {
            return this.results_;
        }

        public RuleEvaluationStepInfo getRulesEvaluation() {
            return this.rulesEvaluation_;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.rulesEvaluation_) + 0 : 0;
            while (i < this.results_.size()) {
                i++;
                computeMessageSize = CodedOutputStream.computeMessageSize(2, (MessageLite) this.results_.get(i)) + computeMessageSize;
            }
            i2 = this.unknownFields.size() + computeMessageSize;
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public boolean hasRulesEvaluation() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = DataLayerEventEvaluationInfo.class.hashCode() + 779;
            if (hasRulesEvaluation()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getRulesEvaluation().hashCode();
            }
            if (getResultsCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getResultsList().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$DataLayerEventEvaluationInfo");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                if (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) {
                    int i = 0;
                    while (i < getResultsCount()) {
                        if (getResults(i).isInitialized()) {
                            i++;
                        } else {
                            this.memoizedIsInitialized = (byte) 0;
                            return false;
                        }
                    }
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.rulesEvaluation_);
            }
            for (int i = 0; i < this.results_.size(); i++) {
                codedOutputStream.writeMessage(2, (MessageLite) this.results_.get(i));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface DebugEventsOrBuilder extends MessageLiteOrBuilder {
        EventInfo getEvent(int i);

        int getEventCount();

        List getEventList();
    }

    public final class DebugEvents extends GeneratedMessageLite implements DebugEventsOrBuilder {
        public static final int EVENT_FIELD_NUMBER = 1;
        public static Parser PARSER = new C0152c();
        private static final DebugEvents defaultInstance = new DebugEvents(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private List event_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements DebugEventsOrBuilder {
            private int bitField0_;
            private List event_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureEventIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.event_ = new ArrayList(this.event_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAllEvent(Iterable iterable) {
                ensureEventIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.event_);
                return this;
            }

            public Builder addEvent(int i, Builder builder) {
                ensureEventIsMutable();
                this.event_.add(i, builder.build());
                return this;
            }

            public Builder addEvent(int i, EventInfo eventInfo) {
                if (eventInfo == null) {
                    throw new NullPointerException();
                }
                ensureEventIsMutable();
                this.event_.add(i, eventInfo);
                return this;
            }

            public Builder addEvent(Builder builder) {
                ensureEventIsMutable();
                this.event_.add(builder.build());
                return this;
            }

            public Builder addEvent(EventInfo eventInfo) {
                if (eventInfo == null) {
                    throw new NullPointerException();
                }
                ensureEventIsMutable();
                this.event_.add(eventInfo);
                return this;
            }

            public DebugEvents build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public DebugEvents buildPartial() {
                DebugEvents debugEvents = new DebugEvents((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.event_ = Collections.unmodifiableList(this.event_);
                    this.bitField0_ &= -2;
                }
                debugEvents.event_ = this.event_;
                return debugEvents;
            }

            public Builder clear() {
                super.clear();
                this.event_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearEvent() {
                this.event_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public DebugEvents getDefaultInstanceForType() {
                return DebugEvents.getDefaultInstance();
            }

            public EventInfo getEvent(int i) {
                return (EventInfo) this.event_.get(i);
            }

            public int getEventCount() {
                return this.event_.size();
            }

            public List getEventList() {
                return Collections.unmodifiableList(this.event_);
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getEventCount(); i++) {
                    if (!getEvent(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(DebugEvents debugEvents) {
                if (debugEvents != DebugEvents.getDefaultInstance()) {
                    if (!debugEvents.event_.isEmpty()) {
                        if (this.event_.isEmpty()) {
                            this.event_ = debugEvents.event_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureEventIsMutable();
                            this.event_.addAll(debugEvents.event_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(debugEvents.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                DebugEvents debugEvents;
                Throwable th;
                DebugEvents debugEvents2;
                try {
                    debugEvents = (DebugEvents) DebugEvents.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (debugEvents != null) {
                        mergeFrom(debugEvents);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    debugEvents = (DebugEvents) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    debugEvents2 = debugEvents;
                    th = th3;
                }
                if (debugEvents2 != null) {
                    mergeFrom(debugEvents2);
                }
                throw th;
            }

            public Builder removeEvent(int i) {
                ensureEventIsMutable();
                this.event_.remove(i);
                return this;
            }

            public Builder setEvent(int i, Builder builder) {
                ensureEventIsMutable();
                this.event_.set(i, builder.build());
                return this;
            }

            public Builder setEvent(int i, EventInfo eventInfo) {
                if (eventInfo == null) {
                    throw new NullPointerException();
                }
                ensureEventIsMutable();
                this.event_.set(i, eventInfo);
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private DebugEvents(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Object obj = null;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            int i = 0;
            while (obj == null) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            obj = 1;
                            break;
                        case 10:
                            if ((i & 1) != 1) {
                                this.event_ = new ArrayList();
                                i |= 1;
                            }
                            this.event_.add(codedInputStream.readMessage(EventInfo.PARSER, extensionRegistryLite));
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.event_ = Collections.unmodifiableList(this.event_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = newOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            if ((i & 1) == 1) {
                this.event_ = Collections.unmodifiableList(this.event_);
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private DebugEvents(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DebugEvents(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static DebugEvents getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.event_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(DebugEvents debugEvents) {
            return newBuilder().mergeFrom(debugEvents);
        }

        public static DebugEvents parseDelimitedFrom(InputStream inputStream) {
            return (DebugEvents) PARSER.parseDelimitedFrom(inputStream);
        }

        public static DebugEvents parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DebugEvents) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static DebugEvents parseFrom(ByteString byteString) {
            return (DebugEvents) PARSER.parseFrom(byteString);
        }

        public static DebugEvents parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DebugEvents) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DebugEvents parseFrom(CodedInputStream codedInputStream) {
            return (DebugEvents) PARSER.parseFrom(codedInputStream);
        }

        public static DebugEvents parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DebugEvents) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static DebugEvents parseFrom(InputStream inputStream) {
            return (DebugEvents) PARSER.parseFrom(inputStream);
        }

        public static DebugEvents parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DebugEvents) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static DebugEvents parseFrom(byte[] bArr) {
            return (DebugEvents) PARSER.parseFrom(bArr);
        }

        public static DebugEvents parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DebugEvents) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DebugEvents)) {
                return super.equals(obj);
            }
            return getEventList().equals(((DebugEvents) obj).getEventList());
        }

        public DebugEvents getDefaultInstanceForType() {
            return defaultInstance;
        }

        public EventInfo getEvent(int i) {
            return (EventInfo) this.event_.get(i);
        }

        public int getEventCount() {
            return this.event_.size();
        }

        public List getEventList() {
            return this.event_;
        }

        public EventInfoOrBuilder getEventOrBuilder(int i) {
            return (EventInfoOrBuilder) this.event_.get(i);
        }

        public List getEventOrBuilderList() {
            return this.event_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.event_.size(); i++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.event_.get(i));
            }
            int size = this.unknownFields.size() + i2;
            this.memoizedSerializedSize = size;
            return size;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = DebugEvents.class.hashCode() + 779;
            if (getEventCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getEventList().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$DebugEvents");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                int i = 0;
                while (i < getEventCount()) {
                    if (getEvent(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            for (int i = 0; i < this.event_.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.event_.get(i));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface EventInfoOrBuilder extends MessageLiteOrBuilder {
        String getContainerId();

        ByteString getContainerIdBytes();

        String getContainerVersion();

        ByteString getContainerVersionBytes();

        DataLayerEventEvaluationInfo getDataLayerEventResult();

        EventType getEventType();

        String getKey();

        ByteString getKeyBytes();

        MacroEvaluationInfo getMacroResult();

        boolean hasContainerId();

        boolean hasContainerVersion();

        boolean hasDataLayerEventResult();

        boolean hasEventType();

        boolean hasKey();

        boolean hasMacroResult();
    }

    public final class EventInfo extends GeneratedMessageLite implements EventInfoOrBuilder {
        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int CONTAINER_VERSION_FIELD_NUMBER = 2;
        public static final int DATA_LAYER_EVENT_RESULT_FIELD_NUMBER = 7;
        public static final int EVENT_TYPE_FIELD_NUMBER = 1;
        public static final int KEY_FIELD_NUMBER = 4;
        public static final int MACRO_RESULT_FIELD_NUMBER = 6;
        public static Parser PARSER = new C0153d();
        private static final EventInfo defaultInstance = new EventInfo(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object containerId_;
        private Object containerVersion_;
        private DataLayerEventEvaluationInfo dataLayerEventResult_;
        private EventType eventType_;
        private Object key_;
        private MacroEvaluationInfo macroResult_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements EventInfoOrBuilder {
            private int bitField0_;
            private Object containerId_ = "";
            private Object containerVersion_ = "";
            private DataLayerEventEvaluationInfo dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
            private EventType eventType_ = EventType.DATA_LAYER_EVENT;
            private Object key_ = "";
            private MacroEvaluationInfo macroResult_ = MacroEvaluationInfo.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public EventInfo build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public EventInfo buildPartial() {
                int i = 1;
                EventInfo eventInfo = new EventInfo((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                eventInfo.eventType_ = this.eventType_;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                eventInfo.containerVersion_ = this.containerVersion_;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                eventInfo.containerId_ = this.containerId_;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                eventInfo.key_ = this.key_;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                eventInfo.macroResult_ = this.macroResult_;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                eventInfo.dataLayerEventResult_ = this.dataLayerEventResult_;
                eventInfo.bitField0_ = i;
                return eventInfo;
            }

            public Builder clear() {
                super.clear();
                this.eventType_ = EventType.DATA_LAYER_EVENT;
                this.bitField0_ &= -2;
                this.containerVersion_ = "";
                this.bitField0_ &= -3;
                this.containerId_ = "";
                this.bitField0_ &= -5;
                this.key_ = "";
                this.bitField0_ &= -9;
                this.macroResult_ = MacroEvaluationInfo.getDefaultInstance();
                this.bitField0_ &= -17;
                this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearContainerId() {
                this.bitField0_ &= -5;
                this.containerId_ = EventInfo.getDefaultInstance().getContainerId();
                return this;
            }

            public Builder clearContainerVersion() {
                this.bitField0_ &= -3;
                this.containerVersion_ = EventInfo.getDefaultInstance().getContainerVersion();
                return this;
            }

            public Builder clearDataLayerEventResult() {
                this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearEventType() {
                this.bitField0_ &= -2;
                this.eventType_ = EventType.DATA_LAYER_EVENT;
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= -9;
                this.key_ = EventInfo.getDefaultInstance().getKey();
                return this;
            }

            public Builder clearMacroResult() {
                this.macroResult_ = MacroEvaluationInfo.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public String getContainerId() {
                Object obj = this.containerId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.containerId_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getContainerIdBytes() {
                Object obj = this.containerId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.containerId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getContainerVersion() {
                Object obj = this.containerVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.containerVersion_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getContainerVersionBytes() {
                Object obj = this.containerVersion_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.containerVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public DataLayerEventEvaluationInfo getDataLayerEventResult() {
                return this.dataLayerEventResult_;
            }

            public EventInfo getDefaultInstanceForType() {
                return EventInfo.getDefaultInstance();
            }

            public EventType getEventType() {
                return this.eventType_;
            }

            public String getKey() {
                Object obj = this.key_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.key_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getKeyBytes() {
                Object obj = this.key_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.key_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public MacroEvaluationInfo getMacroResult() {
                return this.macroResult_;
            }

            public boolean hasContainerId() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasContainerVersion() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasDataLayerEventResult() {
                return (this.bitField0_ & 32) == 32;
            }

            public boolean hasEventType() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasKey() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasMacroResult() {
                return (this.bitField0_ & 16) == 16;
            }

            public final boolean isInitialized() {
                return (!hasMacroResult() || getMacroResult().isInitialized()) ? !hasDataLayerEventResult() || getDataLayerEventResult().isInitialized() : false;
            }

            public Builder mergeDataLayerEventResult(DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo) {
                if ((this.bitField0_ & 32) != 32 || this.dataLayerEventResult_ == DataLayerEventEvaluationInfo.getDefaultInstance()) {
                    this.dataLayerEventResult_ = dataLayerEventEvaluationInfo;
                } else {
                    this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.newBuilder(this.dataLayerEventResult_).mergeFrom(dataLayerEventEvaluationInfo).buildPartial();
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeFrom(EventInfo eventInfo) {
                if (eventInfo != EventInfo.getDefaultInstance()) {
                    if (eventInfo.hasEventType()) {
                        setEventType(eventInfo.getEventType());
                    }
                    if (eventInfo.hasContainerVersion()) {
                        this.bitField0_ |= 2;
                        this.containerVersion_ = eventInfo.containerVersion_;
                    }
                    if (eventInfo.hasContainerId()) {
                        this.bitField0_ |= 4;
                        this.containerId_ = eventInfo.containerId_;
                    }
                    if (eventInfo.hasKey()) {
                        this.bitField0_ |= 8;
                        this.key_ = eventInfo.key_;
                    }
                    if (eventInfo.hasMacroResult()) {
                        mergeMacroResult(eventInfo.getMacroResult());
                    }
                    if (eventInfo.hasDataLayerEventResult()) {
                        mergeDataLayerEventResult(eventInfo.getDataLayerEventResult());
                    }
                    setUnknownFields(getUnknownFields().concat(eventInfo.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                EventInfo eventInfo;
                Throwable th;
                EventInfo eventInfo2;
                try {
                    eventInfo = (EventInfo) EventInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (eventInfo != null) {
                        mergeFrom(eventInfo);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    eventInfo = (EventInfo) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    eventInfo2 = eventInfo;
                    th = th3;
                }
                if (eventInfo2 != null) {
                    mergeFrom(eventInfo2);
                }
                throw th;
            }

            public Builder mergeMacroResult(MacroEvaluationInfo macroEvaluationInfo) {
                if ((this.bitField0_ & 16) != 16 || this.macroResult_ == MacroEvaluationInfo.getDefaultInstance()) {
                    this.macroResult_ = macroEvaluationInfo;
                } else {
                    this.macroResult_ = MacroEvaluationInfo.newBuilder(this.macroResult_).mergeFrom(macroEvaluationInfo).buildPartial();
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setContainerId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.containerId_ = str;
                return this;
            }

            public Builder setContainerIdBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.containerId_ = byteString;
                return this;
            }

            public Builder setContainerVersion(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.containerVersion_ = str;
                return this;
            }

            public Builder setContainerVersionBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.containerVersion_ = byteString;
                return this;
            }

            public Builder setDataLayerEventResult(Builder builder) {
                this.dataLayerEventResult_ = builder.build();
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setDataLayerEventResult(DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo) {
                if (dataLayerEventEvaluationInfo == null) {
                    throw new NullPointerException();
                }
                this.dataLayerEventResult_ = dataLayerEventEvaluationInfo;
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setEventType(EventType eventType) {
                if (eventType == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.eventType_ = eventType;
                return this;
            }

            public Builder setKey(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.key_ = str;
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.key_ = byteString;
                return this;
            }

            public Builder setMacroResult(Builder builder) {
                this.macroResult_ = builder.build();
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setMacroResult(MacroEvaluationInfo macroEvaluationInfo) {
                if (macroEvaluationInfo == null) {
                    throw new NullPointerException();
                }
                this.macroResult_ = macroEvaluationInfo;
                this.bitField0_ |= 16;
                return this;
            }
        }

        public enum EventType implements EnumLite {
            DATA_LAYER_EVENT(0, 1),
            MACRO_REFERENCE(1, 2);
            
            public static final int DATA_LAYER_EVENT_VALUE = 1;
            public static final int MACRO_REFERENCE_VALUE = 2;
            private static EnumLiteMap internalValueMap;
            private final int value;

            static {
                internalValueMap = new C0154e();
            }

            private EventType(int i, int i2) {
                this.value = i2;
            }

            public static EnumLiteMap internalGetValueMap() {
                return internalValueMap;
            }

            public static EventType valueOf(int i) {
                switch (i) {
                    case 1:
                        return DATA_LAYER_EVENT;
                    case 2:
                        return MACRO_REFERENCE;
                    default:
                        return null;
                }
            }

            public final int getNumber() {
                return this.value;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private EventInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            Object obj = null;
            while (obj == null) {
                try {
                    Object obj2;
                    int readTag = codedInputStream.readTag();
                    ByteString readBytes;
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            readTag = 1;
                            break;
                        case 8:
                            int readEnum = codedInputStream.readEnum();
                            EventType valueOf = EventType.valueOf(readEnum);
                            if (valueOf != null) {
                                this.bitField0_ |= 1;
                                this.eventType_ = valueOf;
                                obj2 = obj;
                                break;
                            }
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readEnum);
                            obj2 = obj;
                            break;
                        case 18:
                            readBytes = codedInputStream.readBytes();
                            this.bitField0_ |= 2;
                            this.containerVersion_ = readBytes;
                            obj2 = obj;
                            break;
                        case 26:
                            readBytes = codedInputStream.readBytes();
                            this.bitField0_ |= 4;
                            this.containerId_ = readBytes;
                            obj2 = obj;
                            break;
                        case 34:
                            readBytes = codedInputStream.readBytes();
                            this.bitField0_ |= 8;
                            this.key_ = readBytes;
                            obj2 = obj;
                            break;
                        case 50:
                            Builder toBuilder = (this.bitField0_ & 16) == 16 ? this.macroResult_.toBuilder() : null;
                            this.macroResult_ = (MacroEvaluationInfo) codedInputStream.readMessage(MacroEvaluationInfo.PARSER, extensionRegistryLite);
                            if (toBuilder != null) {
                                toBuilder.mergeFrom(this.macroResult_);
                                this.macroResult_ = toBuilder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            obj2 = obj;
                            break;
                        case 58:
                            Builder toBuilder2 = (this.bitField0_ & 32) == 32 ? this.dataLayerEventResult_.toBuilder() : null;
                            this.dataLayerEventResult_ = (DataLayerEventEvaluationInfo) codedInputStream.readMessage(DataLayerEventEvaluationInfo.PARSER, extensionRegistryLite);
                            if (toBuilder2 != null) {
                                toBuilder2.mergeFrom(this.dataLayerEventResult_);
                                this.dataLayerEventResult_ = toBuilder2.buildPartial();
                            }
                            this.bitField0_ |= 32;
                            obj2 = obj;
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj2 = 1;
                                break;
                            } else {
                                obj2 = obj;
                                break;
                            }
                    }
                    obj = obj2;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = newOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private EventInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private EventInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static EventInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.eventType_ = EventType.DATA_LAYER_EVENT;
            this.containerVersion_ = "";
            this.containerId_ = "";
            this.key_ = "";
            this.macroResult_ = MacroEvaluationInfo.getDefaultInstance();
            this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(EventInfo eventInfo) {
            return newBuilder().mergeFrom(eventInfo);
        }

        public static EventInfo parseDelimitedFrom(InputStream inputStream) {
            return (EventInfo) PARSER.parseDelimitedFrom(inputStream);
        }

        public static EventInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventInfo) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static EventInfo parseFrom(ByteString byteString) {
            return (EventInfo) PARSER.parseFrom(byteString);
        }

        public static EventInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EventInfo) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static EventInfo parseFrom(CodedInputStream codedInputStream) {
            return (EventInfo) PARSER.parseFrom(codedInputStream);
        }

        public static EventInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventInfo) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static EventInfo parseFrom(InputStream inputStream) {
            return (EventInfo) PARSER.parseFrom(inputStream);
        }

        public static EventInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventInfo) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static EventInfo parseFrom(byte[] bArr) {
            return (EventInfo) PARSER.parseFrom(bArr);
        }

        public static EventInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EventInfo) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EventInfo)) {
                return super.equals(obj);
            }
            EventInfo eventInfo = (EventInfo) obj;
            boolean z = hasEventType() == eventInfo.hasEventType();
            if (hasEventType()) {
                z = z && getEventType() == eventInfo.getEventType();
            }
            z = z && hasContainerVersion() == eventInfo.hasContainerVersion();
            if (hasContainerVersion()) {
                z = z && getContainerVersion().equals(eventInfo.getContainerVersion());
            }
            z = z && hasContainerId() == eventInfo.hasContainerId();
            if (hasContainerId()) {
                z = z && getContainerId().equals(eventInfo.getContainerId());
            }
            z = z && hasKey() == eventInfo.hasKey();
            if (hasKey()) {
                z = z && getKey().equals(eventInfo.getKey());
            }
            z = z && hasMacroResult() == eventInfo.hasMacroResult();
            if (hasMacroResult()) {
                z = z && getMacroResult().equals(eventInfo.getMacroResult());
            }
            z = z && hasDataLayerEventResult() == eventInfo.hasDataLayerEventResult();
            return hasDataLayerEventResult() ? z && getDataLayerEventResult().equals(eventInfo.getDataLayerEventResult()) : z;
        }

        public String getContainerId() {
            Object obj = this.containerId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.containerId_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getContainerIdBytes() {
            Object obj = this.containerId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.containerId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getContainerVersion() {
            Object obj = this.containerVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.containerVersion_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getContainerVersionBytes() {
            Object obj = this.containerVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.containerVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public DataLayerEventEvaluationInfo getDataLayerEventResult() {
            return this.dataLayerEventResult_;
        }

        public EventInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public EventType getEventType() {
            return this.eventType_;
        }

        public String getKey() {
            Object obj = this.key_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.key_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getKeyBytes() {
            Object obj = this.key_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.key_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public MacroEvaluationInfo getMacroResult() {
            return this.macroResult_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeEnumSize(1, this.eventType_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeBytesSize(2, getContainerVersionBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.computeBytesSize(3, getContainerIdBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.computeBytesSize(4, getKeyBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.computeMessageSize(6, this.macroResult_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i += CodedOutputStream.computeMessageSize(7, this.dataLayerEventResult_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public boolean hasContainerId() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasContainerVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasDataLayerEventResult() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasEventType() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasKey() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasMacroResult() {
            return (this.bitField0_ & 16) == 16;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = EventInfo.class.hashCode() + 779;
            if (hasEventType()) {
                hashCode = (((hashCode * 37) + 1) * 53) + Internal.hashEnum(getEventType());
            }
            if (hasContainerVersion()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getContainerVersion().hashCode();
            }
            if (hasContainerId()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getContainerId().hashCode();
            }
            if (hasKey()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getKey().hashCode();
            }
            if (hasMacroResult()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getMacroResult().hashCode();
            }
            if (hasDataLayerEventResult()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getDataLayerEventResult().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$EventInfo");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                if (hasMacroResult() && !getMacroResult().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!hasDataLayerEventResult() || getDataLayerEventResult().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.eventType_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getContainerVersionBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getContainerIdBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getKeyBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(6, this.macroResult_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(7, this.dataLayerEventResult_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface MacroEvaluationInfoOrBuilder extends MessageLiteOrBuilder {
        ResolvedFunctionCall getResult();

        RuleEvaluationStepInfo getRulesEvaluation();

        boolean hasResult();

        boolean hasRulesEvaluation();
    }

    public final class MacroEvaluationInfo extends GeneratedMessageLite implements MacroEvaluationInfoOrBuilder {
        public static final int MACRO_FIELD_NUMBER = 47497405;
        public static Parser PARSER = new C0155f();
        public static final int RESULT_FIELD_NUMBER = 3;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final MacroEvaluationInfo defaultInstance = new MacroEvaluationInfo(true);
        public static final GeneratedExtension macro = GeneratedMessageLite.newSingularGeneratedExtension(Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 47497405, FieldType.MESSAGE, MacroEvaluationInfo.class);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ResolvedFunctionCall result_;
        private RuleEvaluationStepInfo rulesEvaluation_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements MacroEvaluationInfoOrBuilder {
            private int bitField0_;
            private ResolvedFunctionCall result_ = ResolvedFunctionCall.getDefaultInstance();
            private RuleEvaluationStepInfo rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public MacroEvaluationInfo build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public MacroEvaluationInfo buildPartial() {
                int i = 1;
                MacroEvaluationInfo macroEvaluationInfo = new MacroEvaluationInfo((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                macroEvaluationInfo.rulesEvaluation_ = this.rulesEvaluation_;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                macroEvaluationInfo.result_ = this.result_;
                macroEvaluationInfo.bitField0_ = i;
                return macroEvaluationInfo;
            }

            public Builder clear() {
                super.clear();
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.bitField0_ &= -2;
                this.result_ = ResolvedFunctionCall.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearResult() {
                this.result_ = ResolvedFunctionCall.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearRulesEvaluation() {
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public MacroEvaluationInfo getDefaultInstanceForType() {
                return MacroEvaluationInfo.getDefaultInstance();
            }

            public ResolvedFunctionCall getResult() {
                return this.result_;
            }

            public RuleEvaluationStepInfo getRulesEvaluation() {
                return this.rulesEvaluation_;
            }

            public boolean hasResult() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasRulesEvaluation() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean isInitialized() {
                return (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) ? !hasResult() || getResult().isInitialized() : false;
            }

            public Builder mergeFrom(MacroEvaluationInfo macroEvaluationInfo) {
                if (macroEvaluationInfo != MacroEvaluationInfo.getDefaultInstance()) {
                    if (macroEvaluationInfo.hasRulesEvaluation()) {
                        mergeRulesEvaluation(macroEvaluationInfo.getRulesEvaluation());
                    }
                    if (macroEvaluationInfo.hasResult()) {
                        mergeResult(macroEvaluationInfo.getResult());
                    }
                    setUnknownFields(getUnknownFields().concat(macroEvaluationInfo.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                MacroEvaluationInfo macroEvaluationInfo;
                MacroEvaluationInfo macroEvaluationInfo2;
                try {
                    macroEvaluationInfo2 = (MacroEvaluationInfo) MacroEvaluationInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (macroEvaluationInfo2 != null) {
                        mergeFrom(macroEvaluationInfo2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    macroEvaluationInfo2 = (MacroEvaluationInfo) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    macroEvaluationInfo = macroEvaluationInfo2;
                    th = th3;
                }
                if (macroEvaluationInfo != null) {
                    mergeFrom(macroEvaluationInfo);
                }
                throw th;
            }

            public Builder mergeResult(ResolvedFunctionCall resolvedFunctionCall) {
                if ((this.bitField0_ & 2) != 2 || this.result_ == ResolvedFunctionCall.getDefaultInstance()) {
                    this.result_ = resolvedFunctionCall;
                } else {
                    this.result_ = ResolvedFunctionCall.newBuilder(this.result_).mergeFrom(resolvedFunctionCall).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeRulesEvaluation(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
                if ((this.bitField0_ & 1) != 1 || this.rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance()) {
                    this.rulesEvaluation_ = ruleEvaluationStepInfo;
                } else {
                    this.rulesEvaluation_ = RuleEvaluationStepInfo.newBuilder(this.rulesEvaluation_).mergeFrom(ruleEvaluationStepInfo).buildPartial();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setResult(Builder builder) {
                this.result_ = builder.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setResult(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                this.result_ = resolvedFunctionCall;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setRulesEvaluation(Builder builder) {
                this.rulesEvaluation_ = builder.build();
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setRulesEvaluation(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
                if (ruleEvaluationStepInfo == null) {
                    throw new NullPointerException();
                }
                this.rulesEvaluation_ = ruleEvaluationStepInfo;
                this.bitField0_ |= 1;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private MacroEvaluationInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            Object obj = null;
            while (obj == null) {
                try {
                    Object obj2;
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            readTag = 1;
                            break;
                        case 10:
                            Builder toBuilder = (this.bitField0_ & 1) == 1 ? this.rulesEvaluation_.toBuilder() : null;
                            this.rulesEvaluation_ = (RuleEvaluationStepInfo) codedInputStream.readMessage(RuleEvaluationStepInfo.PARSER, extensionRegistryLite);
                            if (toBuilder != null) {
                                toBuilder.mergeFrom(this.rulesEvaluation_);
                                this.rulesEvaluation_ = toBuilder.buildPartial();
                            }
                            this.bitField0_ |= 1;
                            obj2 = obj;
                            break;
                        case 26:
                            Builder toBuilder2 = (this.bitField0_ & 2) == 2 ? this.result_.toBuilder() : null;
                            this.result_ = (ResolvedFunctionCall) codedInputStream.readMessage(ResolvedFunctionCall.PARSER, extensionRegistryLite);
                            if (toBuilder2 != null) {
                                toBuilder2.mergeFrom(this.result_);
                                this.result_ = toBuilder2.buildPartial();
                            }
                            this.bitField0_ |= 2;
                            obj2 = obj;
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj2 = 1;
                                break;
                            } else {
                                obj2 = obj;
                                break;
                            }
                    }
                    obj = obj2;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = newOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private MacroEvaluationInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MacroEvaluationInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static MacroEvaluationInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            this.result_ = ResolvedFunctionCall.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(MacroEvaluationInfo macroEvaluationInfo) {
            return newBuilder().mergeFrom(macroEvaluationInfo);
        }

        public static MacroEvaluationInfo parseDelimitedFrom(InputStream inputStream) {
            return (MacroEvaluationInfo) PARSER.parseDelimitedFrom(inputStream);
        }

        public static MacroEvaluationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MacroEvaluationInfo) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static MacroEvaluationInfo parseFrom(ByteString byteString) {
            return (MacroEvaluationInfo) PARSER.parseFrom(byteString);
        }

        public static MacroEvaluationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (MacroEvaluationInfo) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MacroEvaluationInfo parseFrom(CodedInputStream codedInputStream) {
            return (MacroEvaluationInfo) PARSER.parseFrom(codedInputStream);
        }

        public static MacroEvaluationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MacroEvaluationInfo) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static MacroEvaluationInfo parseFrom(InputStream inputStream) {
            return (MacroEvaluationInfo) PARSER.parseFrom(inputStream);
        }

        public static MacroEvaluationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MacroEvaluationInfo) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static MacroEvaluationInfo parseFrom(byte[] bArr) {
            return (MacroEvaluationInfo) PARSER.parseFrom(bArr);
        }

        public static MacroEvaluationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (MacroEvaluationInfo) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MacroEvaluationInfo)) {
                return super.equals(obj);
            }
            MacroEvaluationInfo macroEvaluationInfo = (MacroEvaluationInfo) obj;
            boolean z = hasRulesEvaluation() == macroEvaluationInfo.hasRulesEvaluation();
            if (hasRulesEvaluation()) {
                z = z && getRulesEvaluation().equals(macroEvaluationInfo.getRulesEvaluation());
            }
            z = z && hasResult() == macroEvaluationInfo.hasResult();
            return hasResult() ? z && getResult().equals(macroEvaluationInfo.getResult()) : z;
        }

        public MacroEvaluationInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedFunctionCall getResult() {
            return this.result_;
        }

        public RuleEvaluationStepInfo getRulesEvaluation() {
            return this.rulesEvaluation_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeMessageSize(1, this.rulesEvaluation_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeMessageSize(3, this.result_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public boolean hasResult() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasRulesEvaluation() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = MacroEvaluationInfo.class.hashCode() + 779;
            if (hasRulesEvaluation()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getRulesEvaluation().hashCode();
            }
            if (hasResult()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getResult().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$MacroEvaluationInfo");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                if (hasRulesEvaluation() && !getRulesEvaluation().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!hasResult() || getResult().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.rulesEvaluation_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, this.result_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface ResolvedFunctionCallOrBuilder extends MessageLiteOrBuilder {
        String getAssociatedRuleName();

        ByteString getAssociatedRuleNameBytes();

        ResolvedProperty getProperties(int i);

        int getPropertiesCount();

        List getPropertiesList();

        Value getResult();

        boolean hasAssociatedRuleName();

        boolean hasResult();
    }

    public final class ResolvedFunctionCall extends GeneratedMessageLite implements ResolvedFunctionCallOrBuilder {
        public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
        public static Parser PARSER = new C0156g();
        public static final int PROPERTIES_FIELD_NUMBER = 1;
        public static final int RESULT_FIELD_NUMBER = 2;
        private static final ResolvedFunctionCall defaultInstance = new ResolvedFunctionCall(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private Object associatedRuleName_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List properties_;
        private Value result_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements ResolvedFunctionCallOrBuilder {
            private Object associatedRuleName_ = "";
            private int bitField0_;
            private List properties_ = Collections.emptyList();
            private Value result_ = Value.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensurePropertiesIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.properties_ = new ArrayList(this.properties_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAllProperties(Iterable iterable) {
                ensurePropertiesIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.properties_);
                return this;
            }

            public Builder addProperties(int i, Builder builder) {
                ensurePropertiesIsMutable();
                this.properties_.add(i, builder.build());
                return this;
            }

            public Builder addProperties(int i, ResolvedProperty resolvedProperty) {
                if (resolvedProperty == null) {
                    throw new NullPointerException();
                }
                ensurePropertiesIsMutable();
                this.properties_.add(i, resolvedProperty);
                return this;
            }

            public Builder addProperties(Builder builder) {
                ensurePropertiesIsMutable();
                this.properties_.add(builder.build());
                return this;
            }

            public Builder addProperties(ResolvedProperty resolvedProperty) {
                if (resolvedProperty == null) {
                    throw new NullPointerException();
                }
                ensurePropertiesIsMutable();
                this.properties_.add(resolvedProperty);
                return this;
            }

            public ResolvedFunctionCall build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public ResolvedFunctionCall buildPartial() {
                int i = 1;
                ResolvedFunctionCall resolvedFunctionCall = new ResolvedFunctionCall((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.properties_ = Collections.unmodifiableList(this.properties_);
                    this.bitField0_ &= -2;
                }
                resolvedFunctionCall.properties_ = this.properties_;
                if ((i2 & 2) != 2) {
                    i = 0;
                }
                resolvedFunctionCall.result_ = this.result_;
                if ((i2 & 4) == 4) {
                    i |= 2;
                }
                resolvedFunctionCall.associatedRuleName_ = this.associatedRuleName_;
                resolvedFunctionCall.bitField0_ = i;
                return resolvedFunctionCall;
            }

            public Builder clear() {
                super.clear();
                this.properties_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.result_ = Value.getDefaultInstance();
                this.bitField0_ &= -3;
                this.associatedRuleName_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearAssociatedRuleName() {
                this.bitField0_ &= -5;
                this.associatedRuleName_ = ResolvedFunctionCall.getDefaultInstance().getAssociatedRuleName();
                return this;
            }

            public Builder clearProperties() {
                this.properties_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearResult() {
                this.result_ = Value.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public String getAssociatedRuleName() {
                Object obj = this.associatedRuleName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.associatedRuleName_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getAssociatedRuleNameBytes() {
                Object obj = this.associatedRuleName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.associatedRuleName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public ResolvedFunctionCall getDefaultInstanceForType() {
                return ResolvedFunctionCall.getDefaultInstance();
            }

            public ResolvedProperty getProperties(int i) {
                return (ResolvedProperty) this.properties_.get(i);
            }

            public int getPropertiesCount() {
                return this.properties_.size();
            }

            public List getPropertiesList() {
                return Collections.unmodifiableList(this.properties_);
            }

            public Value getResult() {
                return this.result_;
            }

            public boolean hasAssociatedRuleName() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasResult() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getPropertiesCount(); i++) {
                    if (!getProperties(i).isInitialized()) {
                        return false;
                    }
                }
                return !hasResult() || getResult().isInitialized();
            }

            public Builder mergeFrom(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall != ResolvedFunctionCall.getDefaultInstance()) {
                    if (!resolvedFunctionCall.properties_.isEmpty()) {
                        if (this.properties_.isEmpty()) {
                            this.properties_ = resolvedFunctionCall.properties_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePropertiesIsMutable();
                            this.properties_.addAll(resolvedFunctionCall.properties_);
                        }
                    }
                    if (resolvedFunctionCall.hasResult()) {
                        mergeResult(resolvedFunctionCall.getResult());
                    }
                    if (resolvedFunctionCall.hasAssociatedRuleName()) {
                        this.bitField0_ |= 4;
                        this.associatedRuleName_ = resolvedFunctionCall.associatedRuleName_;
                    }
                    setUnknownFields(getUnknownFields().concat(resolvedFunctionCall.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                ResolvedFunctionCall resolvedFunctionCall;
                Throwable th;
                ResolvedFunctionCall resolvedFunctionCall2;
                try {
                    resolvedFunctionCall = (ResolvedFunctionCall) ResolvedFunctionCall.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (resolvedFunctionCall != null) {
                        mergeFrom(resolvedFunctionCall);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    resolvedFunctionCall = (ResolvedFunctionCall) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    resolvedFunctionCall2 = resolvedFunctionCall;
                    th = th3;
                }
                if (resolvedFunctionCall2 != null) {
                    mergeFrom(resolvedFunctionCall2);
                }
                throw th;
            }

            public Builder mergeResult(Value value) {
                if ((this.bitField0_ & 2) != 2 || this.result_ == Value.getDefaultInstance()) {
                    this.result_ = value;
                } else {
                    this.result_ = Value.newBuilder(this.result_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder removeProperties(int i) {
                ensurePropertiesIsMutable();
                this.properties_.remove(i);
                return this;
            }

            public Builder setAssociatedRuleName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.associatedRuleName_ = str;
                return this;
            }

            public Builder setAssociatedRuleNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.associatedRuleName_ = byteString;
                return this;
            }

            public Builder setProperties(int i, Builder builder) {
                ensurePropertiesIsMutable();
                this.properties_.set(i, builder.build());
                return this;
            }

            public Builder setProperties(int i, ResolvedProperty resolvedProperty) {
                if (resolvedProperty == null) {
                    throw new NullPointerException();
                }
                ensurePropertiesIsMutable();
                this.properties_.set(i, resolvedProperty);
                return this;
            }

            public Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder) {
                this.result_ = builder.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setResult(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result_ = value;
                this.bitField0_ |= 2;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ResolvedFunctionCall(com.google.tagmanager.protobuf.CodedInputStream r9, com.google.tagmanager.protobuf.ExtensionRegistryLite r10) {
            /*
            r8 = this;
            r2 = 0;
            r0 = -1;
            r1 = 1;
            r8.<init>();
            r8.memoizedIsInitialized = r0;
            r8.memoizedSerializedSize = r0;
            r8.initFields();
            r5 = com.google.tagmanager.protobuf.ByteString.newOutput();
            r6 = com.google.tagmanager.protobuf.CodedOutputStream.newInstance(r5);
            r3 = r2;
        L_0x0016:
            if (r2 != 0) goto L_0x0086;
        L_0x0018:
            r0 = r9.readTag();	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            switch(r0) {
                case 0: goto L_0x002a;
                case 10: goto L_0x002d;
                case 18: goto L_0x0049;
                case 26: goto L_0x0077;
                default: goto L_0x001f;
            };	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
        L_0x001f:
            r0 = r8.parseUnknownField(r9, r6, r10, r0);	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            if (r0 != 0) goto L_0x0100;
        L_0x0025:
            r0 = r1;
            r2 = r3;
        L_0x0027:
            r3 = r2;
            r2 = r0;
            goto L_0x0016;
        L_0x002a:
            r0 = r1;
            r2 = r3;
            goto L_0x0027;
        L_0x002d:
            r0 = r3 & 1;
            if (r0 == r1) goto L_0x00fd;
        L_0x0031:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r8.properties_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0 = r3 | 1;
        L_0x003a:
            r3 = r8.properties_;	 Catch:{ InvalidProtocolBufferException -> 0x00f6, IOException -> 0x00f2, all -> 0x00ee }
            r4 = com.google.analytics.containertag.proto.Debug.ResolvedProperty.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x00f6, IOException -> 0x00f2, all -> 0x00ee }
            r4 = r9.readMessage(r4, r10);	 Catch:{ InvalidProtocolBufferException -> 0x00f6, IOException -> 0x00f2, all -> 0x00ee }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x00f6, IOException -> 0x00f2, all -> 0x00ee }
            r7 = r2;
            r2 = r0;
            r0 = r7;
            goto L_0x0027;
        L_0x0049:
            r0 = 0;
            r4 = r8.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r4 = r4 & 1;
            if (r4 != r1) goto L_0x00fa;
        L_0x0050:
            r0 = r8.result_;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0 = r0.toBuilder();	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r4 = r0;
        L_0x0057:
            r0 = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0 = r9.readMessage(r0, r10);	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r0;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r8.result_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            if (r4 == 0) goto L_0x006e;
        L_0x0063:
            r0 = r8.result_;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r4.mergeFrom(r0);	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0 = r4.buildPartial();	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r8.result_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
        L_0x006e:
            r0 = r8.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0 = r0 | 1;
            r8.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0 = r2;
            r2 = r3;
            goto L_0x0027;
        L_0x0077:
            r0 = r9.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r4 = r8.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r4 = r4 | 2;
            r8.bitField0_ = r4;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r8.associatedRuleName_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x00af, IOException -> 0x00cf }
            r0 = r2;
            r2 = r3;
            goto L_0x0027;
        L_0x0086:
            r0 = r3 & 1;
            if (r0 != r1) goto L_0x0092;
        L_0x008a:
            r0 = r8.properties_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r8.properties_ = r0;
        L_0x0092:
            r6.flush();	 Catch:{ IOException -> 0x009f, all -> 0x00a7 }
            r0 = r5.toByteString();
            r8.unknownFields = r0;
        L_0x009b:
            r8.makeExtensionsImmutable();
            return;
        L_0x009f:
            r0 = move-exception;
            r0 = r5.toByteString();
            r8.unknownFields = r0;
            goto L_0x009b;
        L_0x00a7:
            r0 = move-exception;
            r1 = r5.toByteString();
            r8.unknownFields = r1;
            throw r0;
        L_0x00af:
            r0 = move-exception;
        L_0x00b0:
            r0 = r0.setUnfinishedMessage(r8);	 Catch:{ all -> 0x00b5 }
            throw r0;	 Catch:{ all -> 0x00b5 }
        L_0x00b5:
            r0 = move-exception;
        L_0x00b6:
            r2 = r3 & 1;
            if (r2 != r1) goto L_0x00c2;
        L_0x00ba:
            r1 = r8.properties_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r8.properties_ = r1;
        L_0x00c2:
            r6.flush();	 Catch:{ IOException -> 0x00de, all -> 0x00e6 }
            r1 = r5.toByteString();
            r8.unknownFields = r1;
        L_0x00cb:
            r8.makeExtensionsImmutable();
            throw r0;
        L_0x00cf:
            r0 = move-exception;
        L_0x00d0:
            r2 = new com.google.tagmanager.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x00b5 }
            r0 = r0.getMessage();	 Catch:{ all -> 0x00b5 }
            r2.<init>(r0);	 Catch:{ all -> 0x00b5 }
            r0 = r2.setUnfinishedMessage(r8);	 Catch:{ all -> 0x00b5 }
            throw r0;	 Catch:{ all -> 0x00b5 }
        L_0x00de:
            r1 = move-exception;
            r1 = r5.toByteString();
            r8.unknownFields = r1;
            goto L_0x00cb;
        L_0x00e6:
            r0 = move-exception;
            r1 = r5.toByteString();
            r8.unknownFields = r1;
            throw r0;
        L_0x00ee:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x00b6;
        L_0x00f2:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x00d0;
        L_0x00f6:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x00b0;
        L_0x00fa:
            r4 = r0;
            goto L_0x0057;
        L_0x00fd:
            r0 = r3;
            goto L_0x003a;
        L_0x0100:
            r0 = r2;
            r2 = r3;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.<init>(com.google.tagmanager.protobuf.CodedInputStream, com.google.tagmanager.protobuf.ExtensionRegistryLite):void");
        }

        private ResolvedFunctionCall(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ResolvedFunctionCall(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ResolvedFunctionCall getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.properties_ = Collections.emptyList();
            this.result_ = Value.getDefaultInstance();
            this.associatedRuleName_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ResolvedFunctionCall resolvedFunctionCall) {
            return newBuilder().mergeFrom(resolvedFunctionCall);
        }

        public static ResolvedFunctionCall parseDelimitedFrom(InputStream inputStream) {
            return (ResolvedFunctionCall) PARSER.parseDelimitedFrom(inputStream);
        }

        public static ResolvedFunctionCall parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedFunctionCall) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ResolvedFunctionCall parseFrom(ByteString byteString) {
            return (ResolvedFunctionCall) PARSER.parseFrom(byteString);
        }

        public static ResolvedFunctionCall parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedFunctionCall) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ResolvedFunctionCall parseFrom(CodedInputStream codedInputStream) {
            return (ResolvedFunctionCall) PARSER.parseFrom(codedInputStream);
        }

        public static ResolvedFunctionCall parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedFunctionCall) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ResolvedFunctionCall parseFrom(InputStream inputStream) {
            return (ResolvedFunctionCall) PARSER.parseFrom(inputStream);
        }

        public static ResolvedFunctionCall parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedFunctionCall) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ResolvedFunctionCall parseFrom(byte[] bArr) {
            return (ResolvedFunctionCall) PARSER.parseFrom(bArr);
        }

        public static ResolvedFunctionCall parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedFunctionCall) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedFunctionCall)) {
                return super.equals(obj);
            }
            ResolvedFunctionCall resolvedFunctionCall = (ResolvedFunctionCall) obj;
            boolean z = (getPropertiesList().equals(resolvedFunctionCall.getPropertiesList())) && hasResult() == resolvedFunctionCall.hasResult();
            if (hasResult()) {
                z = z && getResult().equals(resolvedFunctionCall.getResult());
            }
            z = z && hasAssociatedRuleName() == resolvedFunctionCall.hasAssociatedRuleName();
            return hasAssociatedRuleName() ? z && getAssociatedRuleName().equals(resolvedFunctionCall.getAssociatedRuleName()) : z;
        }

        public String getAssociatedRuleName() {
            Object obj = this.associatedRuleName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.associatedRuleName_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getAssociatedRuleNameBytes() {
            Object obj = this.associatedRuleName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.associatedRuleName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public ResolvedFunctionCall getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedProperty getProperties(int i) {
            return (ResolvedProperty) this.properties_.get(i);
        }

        public int getPropertiesCount() {
            return this.properties_.size();
        }

        public List getPropertiesList() {
            return this.properties_;
        }

        public ResolvedPropertyOrBuilder getPropertiesOrBuilder(int i) {
            return (ResolvedPropertyOrBuilder) this.properties_.get(i);
        }

        public List getPropertiesOrBuilderList() {
            return this.properties_;
        }

        public Value getResult() {
            return this.result_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.properties_.size(); i++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.properties_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeMessageSize(2, this.result_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeBytesSize(3, getAssociatedRuleNameBytes());
            }
            int size = this.unknownFields.size() + i2;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasAssociatedRuleName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasResult() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ResolvedFunctionCall.class.hashCode() + 779;
            if (getPropertiesCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getPropertiesList().hashCode();
            }
            if (hasResult()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getResult().hashCode();
            }
            if (hasAssociatedRuleName()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getAssociatedRuleName().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedFunctionCall");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                int i = 0;
                while (i < getPropertiesCount()) {
                    if (getProperties(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!hasResult() || getResult().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            for (int i = 0; i < this.properties_.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.properties_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(2, this.result_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(3, getAssociatedRuleNameBytes());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface ResolvedPropertyOrBuilder extends MessageLiteOrBuilder {
        String getKey();

        ByteString getKeyBytes();

        Value getValue();

        boolean hasKey();

        boolean hasValue();
    }

    public final class ResolvedProperty extends GeneratedMessageLite implements ResolvedPropertyOrBuilder {
        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser PARSER = new C0157h();
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final ResolvedProperty defaultInstance = new ResolvedProperty(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object key_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private Value value_;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements ResolvedPropertyOrBuilder {
            private int bitField0_;
            private Object key_ = "";
            private Value value_ = Value.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public ResolvedProperty build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public ResolvedProperty buildPartial() {
                int i = 1;
                ResolvedProperty resolvedProperty = new ResolvedProperty((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                resolvedProperty.key_ = this.key_;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                resolvedProperty.value_ = this.value_;
                resolvedProperty.bitField0_ = i;
                return resolvedProperty;
            }

            public Builder clear() {
                super.clear();
                this.key_ = "";
                this.bitField0_ &= -2;
                this.value_ = Value.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= -2;
                this.key_ = ResolvedProperty.getDefaultInstance().getKey();
                return this;
            }

            public Builder clearValue() {
                this.value_ = Value.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public ResolvedProperty getDefaultInstanceForType() {
                return ResolvedProperty.getDefaultInstance();
            }

            public String getKey() {
                Object obj = this.key_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.key_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getKeyBytes() {
                Object obj = this.key_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.key_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Value getValue() {
                return this.value_;
            }

            public boolean hasKey() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean isInitialized() {
                return !hasValue() || getValue().isInitialized();
            }

            public Builder mergeFrom(ResolvedProperty resolvedProperty) {
                if (resolvedProperty != ResolvedProperty.getDefaultInstance()) {
                    if (resolvedProperty.hasKey()) {
                        this.bitField0_ |= 1;
                        this.key_ = resolvedProperty.key_;
                    }
                    if (resolvedProperty.hasValue()) {
                        mergeValue(resolvedProperty.getValue());
                    }
                    setUnknownFields(getUnknownFields().concat(resolvedProperty.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                ResolvedProperty resolvedProperty;
                ResolvedProperty resolvedProperty2;
                try {
                    resolvedProperty2 = (ResolvedProperty) ResolvedProperty.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (resolvedProperty2 != null) {
                        mergeFrom(resolvedProperty2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    resolvedProperty2 = (ResolvedProperty) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    resolvedProperty = resolvedProperty2;
                    th = th3;
                }
                if (resolvedProperty != null) {
                    mergeFrom(resolvedProperty);
                }
                throw th;
            }

            public Builder mergeValue(Value value) {
                if ((this.bitField0_ & 2) != 2 || this.value_ == Value.getDefaultInstance()) {
                    this.value_ = value;
                } else {
                    this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setKey(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.key_ = str;
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.key_ = byteString;
                return this;
            }

            public Builder setValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder) {
                this.value_ = builder.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setValue(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.value_ = value;
                this.bitField0_ |= 2;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private ResolvedProperty(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            Object obj = null;
            while (obj == null) {
                try {
                    Object obj2;
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            readTag = 1;
                            break;
                        case 10:
                            ByteString readBytes = codedInputStream.readBytes();
                            this.bitField0_ |= 1;
                            this.key_ = readBytes;
                            obj2 = obj;
                            break;
                        case 18:
                            com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder toBuilder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                            this.value_ = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                            if (toBuilder != null) {
                                toBuilder.mergeFrom(this.value_);
                                this.value_ = toBuilder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                            obj2 = obj;
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj2 = 1;
                                break;
                            } else {
                                obj2 = obj;
                                break;
                            }
                    }
                    obj = obj2;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = newOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private ResolvedProperty(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ResolvedProperty(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ResolvedProperty getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.key_ = "";
            this.value_ = Value.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ResolvedProperty resolvedProperty) {
            return newBuilder().mergeFrom(resolvedProperty);
        }

        public static ResolvedProperty parseDelimitedFrom(InputStream inputStream) {
            return (ResolvedProperty) PARSER.parseDelimitedFrom(inputStream);
        }

        public static ResolvedProperty parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedProperty) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ResolvedProperty parseFrom(ByteString byteString) {
            return (ResolvedProperty) PARSER.parseFrom(byteString);
        }

        public static ResolvedProperty parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedProperty) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ResolvedProperty parseFrom(CodedInputStream codedInputStream) {
            return (ResolvedProperty) PARSER.parseFrom(codedInputStream);
        }

        public static ResolvedProperty parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedProperty) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ResolvedProperty parseFrom(InputStream inputStream) {
            return (ResolvedProperty) PARSER.parseFrom(inputStream);
        }

        public static ResolvedProperty parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedProperty) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ResolvedProperty parseFrom(byte[] bArr) {
            return (ResolvedProperty) PARSER.parseFrom(bArr);
        }

        public static ResolvedProperty parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedProperty) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedProperty)) {
                return super.equals(obj);
            }
            ResolvedProperty resolvedProperty = (ResolvedProperty) obj;
            boolean z = hasKey() == resolvedProperty.hasKey();
            if (hasKey()) {
                z = z && getKey().equals(resolvedProperty.getKey());
            }
            z = z && hasValue() == resolvedProperty.hasValue();
            return hasValue() ? z && getValue().equals(resolvedProperty.getValue()) : z;
        }

        public ResolvedProperty getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getKey() {
            Object obj = this.key_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.key_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getKeyBytes() {
            Object obj = this.key_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.key_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeBytesSize(1, getKeyBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeMessageSize(2, this.value_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public Value getValue() {
            return this.value_;
        }

        public boolean hasKey() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 2) == 2;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ResolvedProperty.class.hashCode() + 779;
            if (hasKey()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getKey().hashCode();
            }
            if (hasValue()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getValue().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedProperty");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                if (!hasValue() || getValue().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, getKeyBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.value_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface ResolvedRuleOrBuilder extends MessageLiteOrBuilder {
        ResolvedFunctionCall getAddMacros(int i);

        int getAddMacrosCount();

        List getAddMacrosList();

        ResolvedFunctionCall getAddTags(int i);

        int getAddTagsCount();

        List getAddTagsList();

        ResolvedFunctionCall getNegativePredicates(int i);

        int getNegativePredicatesCount();

        List getNegativePredicatesList();

        ResolvedFunctionCall getPositivePredicates(int i);

        int getPositivePredicatesCount();

        List getPositivePredicatesList();

        ResolvedFunctionCall getRemoveMacros(int i);

        int getRemoveMacrosCount();

        List getRemoveMacrosList();

        ResolvedFunctionCall getRemoveTags(int i);

        int getRemoveTagsCount();

        List getRemoveTagsList();

        Value getResult();

        boolean hasResult();
    }

    public final class ResolvedRule extends GeneratedMessageLite implements ResolvedRuleOrBuilder {
        public static final int ADD_MACROS_FIELD_NUMBER = 5;
        public static final int ADD_TAGS_FIELD_NUMBER = 3;
        public static final int NEGATIVE_PREDICATES_FIELD_NUMBER = 2;
        public static Parser PARSER = new C0158i();
        public static final int POSITIVE_PREDICATES_FIELD_NUMBER = 1;
        public static final int REMOVE_MACROS_FIELD_NUMBER = 6;
        public static final int REMOVE_TAGS_FIELD_NUMBER = 4;
        public static final int RESULT_FIELD_NUMBER = 7;
        private static final ResolvedRule defaultInstance = new ResolvedRule(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private List addMacros_;
        private List addTags_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List negativePredicates_;
        private List positivePredicates_;
        private List removeMacros_;
        private List removeTags_;
        private Value result_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements ResolvedRuleOrBuilder {
            private List addMacros_ = Collections.emptyList();
            private List addTags_ = Collections.emptyList();
            private int bitField0_;
            private List negativePredicates_ = Collections.emptyList();
            private List positivePredicates_ = Collections.emptyList();
            private List removeMacros_ = Collections.emptyList();
            private List removeTags_ = Collections.emptyList();
            private Value result_ = Value.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAddMacrosIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.addMacros_ = new ArrayList(this.addMacros_);
                    this.bitField0_ |= 16;
                }
            }

            private void ensureAddTagsIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.addTags_ = new ArrayList(this.addTags_);
                    this.bitField0_ |= 4;
                }
            }

            private void ensureNegativePredicatesIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.negativePredicates_ = new ArrayList(this.negativePredicates_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensurePositivePredicatesIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.positivePredicates_ = new ArrayList(this.positivePredicates_);
                    this.bitField0_ |= 1;
                }
            }

            private void ensureRemoveMacrosIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.removeMacros_ = new ArrayList(this.removeMacros_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureRemoveTagsIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.removeTags_ = new ArrayList(this.removeTags_);
                    this.bitField0_ |= 8;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAddMacros(int i, Builder builder) {
                ensureAddMacrosIsMutable();
                this.addMacros_.add(i, builder.build());
                return this;
            }

            public Builder addAddMacros(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureAddMacrosIsMutable();
                this.addMacros_.add(i, resolvedFunctionCall);
                return this;
            }

            public Builder addAddMacros(Builder builder) {
                ensureAddMacrosIsMutable();
                this.addMacros_.add(builder.build());
                return this;
            }

            public Builder addAddMacros(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureAddMacrosIsMutable();
                this.addMacros_.add(resolvedFunctionCall);
                return this;
            }

            public Builder addAddTags(int i, Builder builder) {
                ensureAddTagsIsMutable();
                this.addTags_.add(i, builder.build());
                return this;
            }

            public Builder addAddTags(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureAddTagsIsMutable();
                this.addTags_.add(i, resolvedFunctionCall);
                return this;
            }

            public Builder addAddTags(Builder builder) {
                ensureAddTagsIsMutable();
                this.addTags_.add(builder.build());
                return this;
            }

            public Builder addAddTags(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureAddTagsIsMutable();
                this.addTags_.add(resolvedFunctionCall);
                return this;
            }

            public Builder addAllAddMacros(Iterable iterable) {
                ensureAddMacrosIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.addMacros_);
                return this;
            }

            public Builder addAllAddTags(Iterable iterable) {
                ensureAddTagsIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.addTags_);
                return this;
            }

            public Builder addAllNegativePredicates(Iterable iterable) {
                ensureNegativePredicatesIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.negativePredicates_);
                return this;
            }

            public Builder addAllPositivePredicates(Iterable iterable) {
                ensurePositivePredicatesIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.positivePredicates_);
                return this;
            }

            public Builder addAllRemoveMacros(Iterable iterable) {
                ensureRemoveMacrosIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.removeMacros_);
                return this;
            }

            public Builder addAllRemoveTags(Iterable iterable) {
                ensureRemoveTagsIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.removeTags_);
                return this;
            }

            public Builder addNegativePredicates(int i, Builder builder) {
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.add(i, builder.build());
                return this;
            }

            public Builder addNegativePredicates(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.add(i, resolvedFunctionCall);
                return this;
            }

            public Builder addNegativePredicates(Builder builder) {
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.add(builder.build());
                return this;
            }

            public Builder addNegativePredicates(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.add(resolvedFunctionCall);
                return this;
            }

            public Builder addPositivePredicates(int i, Builder builder) {
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.add(i, builder.build());
                return this;
            }

            public Builder addPositivePredicates(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.add(i, resolvedFunctionCall);
                return this;
            }

            public Builder addPositivePredicates(Builder builder) {
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.add(builder.build());
                return this;
            }

            public Builder addPositivePredicates(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.add(resolvedFunctionCall);
                return this;
            }

            public Builder addRemoveMacros(int i, Builder builder) {
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.add(i, builder.build());
                return this;
            }

            public Builder addRemoveMacros(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.add(i, resolvedFunctionCall);
                return this;
            }

            public Builder addRemoveMacros(Builder builder) {
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.add(builder.build());
                return this;
            }

            public Builder addRemoveMacros(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.add(resolvedFunctionCall);
                return this;
            }

            public Builder addRemoveTags(int i, Builder builder) {
                ensureRemoveTagsIsMutable();
                this.removeTags_.add(i, builder.build());
                return this;
            }

            public Builder addRemoveTags(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureRemoveTagsIsMutable();
                this.removeTags_.add(i, resolvedFunctionCall);
                return this;
            }

            public Builder addRemoveTags(Builder builder) {
                ensureRemoveTagsIsMutable();
                this.removeTags_.add(builder.build());
                return this;
            }

            public Builder addRemoveTags(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureRemoveTagsIsMutable();
                this.removeTags_.add(resolvedFunctionCall);
                return this;
            }

            public ResolvedRule build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public ResolvedRule buildPartial() {
                int i = 1;
                ResolvedRule resolvedRule = new ResolvedRule((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.positivePredicates_ = Collections.unmodifiableList(this.positivePredicates_);
                    this.bitField0_ &= -2;
                }
                resolvedRule.positivePredicates_ = this.positivePredicates_;
                if ((this.bitField0_ & 2) == 2) {
                    this.negativePredicates_ = Collections.unmodifiableList(this.negativePredicates_);
                    this.bitField0_ &= -3;
                }
                resolvedRule.negativePredicates_ = this.negativePredicates_;
                if ((this.bitField0_ & 4) == 4) {
                    this.addTags_ = Collections.unmodifiableList(this.addTags_);
                    this.bitField0_ &= -5;
                }
                resolvedRule.addTags_ = this.addTags_;
                if ((this.bitField0_ & 8) == 8) {
                    this.removeTags_ = Collections.unmodifiableList(this.removeTags_);
                    this.bitField0_ &= -9;
                }
                resolvedRule.removeTags_ = this.removeTags_;
                if ((this.bitField0_ & 16) == 16) {
                    this.addMacros_ = Collections.unmodifiableList(this.addMacros_);
                    this.bitField0_ &= -17;
                }
                resolvedRule.addMacros_ = this.addMacros_;
                if ((this.bitField0_ & 32) == 32) {
                    this.removeMacros_ = Collections.unmodifiableList(this.removeMacros_);
                    this.bitField0_ &= -33;
                }
                resolvedRule.removeMacros_ = this.removeMacros_;
                if ((i2 & 64) != 64) {
                    i = 0;
                }
                resolvedRule.result_ = this.result_;
                resolvedRule.bitField0_ = i;
                return resolvedRule;
            }

            public Builder clear() {
                super.clear();
                this.positivePredicates_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.negativePredicates_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.addTags_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.removeTags_ = Collections.emptyList();
                this.bitField0_ &= -9;
                this.addMacros_ = Collections.emptyList();
                this.bitField0_ &= -17;
                this.removeMacros_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.result_ = Value.getDefaultInstance();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearAddMacros() {
                this.addMacros_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearAddTags() {
                this.addTags_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearNegativePredicates() {
                this.negativePredicates_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearPositivePredicates() {
                this.positivePredicates_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearRemoveMacros() {
                this.removeMacros_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearRemoveTags() {
                this.removeTags_ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clearResult() {
                this.result_ = Value.getDefaultInstance();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public ResolvedFunctionCall getAddMacros(int i) {
                return (ResolvedFunctionCall) this.addMacros_.get(i);
            }

            public int getAddMacrosCount() {
                return this.addMacros_.size();
            }

            public List getAddMacrosList() {
                return Collections.unmodifiableList(this.addMacros_);
            }

            public ResolvedFunctionCall getAddTags(int i) {
                return (ResolvedFunctionCall) this.addTags_.get(i);
            }

            public int getAddTagsCount() {
                return this.addTags_.size();
            }

            public List getAddTagsList() {
                return Collections.unmodifiableList(this.addTags_);
            }

            public ResolvedRule getDefaultInstanceForType() {
                return ResolvedRule.getDefaultInstance();
            }

            public ResolvedFunctionCall getNegativePredicates(int i) {
                return (ResolvedFunctionCall) this.negativePredicates_.get(i);
            }

            public int getNegativePredicatesCount() {
                return this.negativePredicates_.size();
            }

            public List getNegativePredicatesList() {
                return Collections.unmodifiableList(this.negativePredicates_);
            }

            public ResolvedFunctionCall getPositivePredicates(int i) {
                return (ResolvedFunctionCall) this.positivePredicates_.get(i);
            }

            public int getPositivePredicatesCount() {
                return this.positivePredicates_.size();
            }

            public List getPositivePredicatesList() {
                return Collections.unmodifiableList(this.positivePredicates_);
            }

            public ResolvedFunctionCall getRemoveMacros(int i) {
                return (ResolvedFunctionCall) this.removeMacros_.get(i);
            }

            public int getRemoveMacrosCount() {
                return this.removeMacros_.size();
            }

            public List getRemoveMacrosList() {
                return Collections.unmodifiableList(this.removeMacros_);
            }

            public ResolvedFunctionCall getRemoveTags(int i) {
                return (ResolvedFunctionCall) this.removeTags_.get(i);
            }

            public int getRemoveTagsCount() {
                return this.removeTags_.size();
            }

            public List getRemoveTagsList() {
                return Collections.unmodifiableList(this.removeTags_);
            }

            public Value getResult() {
                return this.result_;
            }

            public boolean hasResult() {
                return (this.bitField0_ & 64) == 64;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getPositivePredicatesCount(); i++) {
                    if (!getPositivePredicates(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getNegativePredicatesCount(); i++) {
                    if (!getNegativePredicates(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getAddTagsCount(); i++) {
                    if (!getAddTags(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getRemoveTagsCount(); i++) {
                    if (!getRemoveTags(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getAddMacrosCount(); i++) {
                    if (!getAddMacros(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getRemoveMacrosCount(); i++) {
                    if (!getRemoveMacros(i).isInitialized()) {
                        return false;
                    }
                }
                return !hasResult() || getResult().isInitialized();
            }

            public Builder mergeFrom(ResolvedRule resolvedRule) {
                if (resolvedRule != ResolvedRule.getDefaultInstance()) {
                    if (!resolvedRule.positivePredicates_.isEmpty()) {
                        if (this.positivePredicates_.isEmpty()) {
                            this.positivePredicates_ = resolvedRule.positivePredicates_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePositivePredicatesIsMutable();
                            this.positivePredicates_.addAll(resolvedRule.positivePredicates_);
                        }
                    }
                    if (!resolvedRule.negativePredicates_.isEmpty()) {
                        if (this.negativePredicates_.isEmpty()) {
                            this.negativePredicates_ = resolvedRule.negativePredicates_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureNegativePredicatesIsMutable();
                            this.negativePredicates_.addAll(resolvedRule.negativePredicates_);
                        }
                    }
                    if (!resolvedRule.addTags_.isEmpty()) {
                        if (this.addTags_.isEmpty()) {
                            this.addTags_ = resolvedRule.addTags_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureAddTagsIsMutable();
                            this.addTags_.addAll(resolvedRule.addTags_);
                        }
                    }
                    if (!resolvedRule.removeTags_.isEmpty()) {
                        if (this.removeTags_.isEmpty()) {
                            this.removeTags_ = resolvedRule.removeTags_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureRemoveTagsIsMutable();
                            this.removeTags_.addAll(resolvedRule.removeTags_);
                        }
                    }
                    if (!resolvedRule.addMacros_.isEmpty()) {
                        if (this.addMacros_.isEmpty()) {
                            this.addMacros_ = resolvedRule.addMacros_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureAddMacrosIsMutable();
                            this.addMacros_.addAll(resolvedRule.addMacros_);
                        }
                    }
                    if (!resolvedRule.removeMacros_.isEmpty()) {
                        if (this.removeMacros_.isEmpty()) {
                            this.removeMacros_ = resolvedRule.removeMacros_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureRemoveMacrosIsMutable();
                            this.removeMacros_.addAll(resolvedRule.removeMacros_);
                        }
                    }
                    if (resolvedRule.hasResult()) {
                        mergeResult(resolvedRule.getResult());
                    }
                    setUnknownFields(getUnknownFields().concat(resolvedRule.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                ResolvedRule resolvedRule;
                ResolvedRule resolvedRule2;
                try {
                    resolvedRule2 = (ResolvedRule) ResolvedRule.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (resolvedRule2 != null) {
                        mergeFrom(resolvedRule2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    resolvedRule2 = (ResolvedRule) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    resolvedRule = resolvedRule2;
                    th = th3;
                }
                if (resolvedRule != null) {
                    mergeFrom(resolvedRule);
                }
                throw th;
            }

            public Builder mergeResult(Value value) {
                if ((this.bitField0_ & 64) != 64 || this.result_ == Value.getDefaultInstance()) {
                    this.result_ = value;
                } else {
                    this.result_ = Value.newBuilder(this.result_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder removeAddMacros(int i) {
                ensureAddMacrosIsMutable();
                this.addMacros_.remove(i);
                return this;
            }

            public Builder removeAddTags(int i) {
                ensureAddTagsIsMutable();
                this.addTags_.remove(i);
                return this;
            }

            public Builder removeNegativePredicates(int i) {
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.remove(i);
                return this;
            }

            public Builder removePositivePredicates(int i) {
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.remove(i);
                return this;
            }

            public Builder removeRemoveMacros(int i) {
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.remove(i);
                return this;
            }

            public Builder removeRemoveTags(int i) {
                ensureRemoveTagsIsMutable();
                this.removeTags_.remove(i);
                return this;
            }

            public Builder setAddMacros(int i, Builder builder) {
                ensureAddMacrosIsMutable();
                this.addMacros_.set(i, builder.build());
                return this;
            }

            public Builder setAddMacros(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureAddMacrosIsMutable();
                this.addMacros_.set(i, resolvedFunctionCall);
                return this;
            }

            public Builder setAddTags(int i, Builder builder) {
                ensureAddTagsIsMutable();
                this.addTags_.set(i, builder.build());
                return this;
            }

            public Builder setAddTags(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureAddTagsIsMutable();
                this.addTags_.set(i, resolvedFunctionCall);
                return this;
            }

            public Builder setNegativePredicates(int i, Builder builder) {
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.set(i, builder.build());
                return this;
            }

            public Builder setNegativePredicates(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.set(i, resolvedFunctionCall);
                return this;
            }

            public Builder setPositivePredicates(int i, Builder builder) {
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.set(i, builder.build());
                return this;
            }

            public Builder setPositivePredicates(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.set(i, resolvedFunctionCall);
                return this;
            }

            public Builder setRemoveMacros(int i, Builder builder) {
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.set(i, builder.build());
                return this;
            }

            public Builder setRemoveMacros(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.set(i, resolvedFunctionCall);
                return this;
            }

            public Builder setRemoveTags(int i, Builder builder) {
                ensureRemoveTagsIsMutable();
                this.removeTags_.set(i, builder.build());
                return this;
            }

            public Builder setRemoveTags(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureRemoveTagsIsMutable();
                this.removeTags_.set(i, resolvedFunctionCall);
                return this;
            }

            public Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder) {
                this.result_ = builder.build();
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setResult(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result_ = value;
                this.bitField0_ |= 64;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ResolvedRule(com.google.tagmanager.protobuf.CodedInputStream r13, com.google.tagmanager.protobuf.ExtensionRegistryLite r14) {
            /*
            r12 = this;
            r10 = 16;
            r9 = 8;
            r8 = 4;
            r7 = 2;
            r1 = 1;
            r12.<init>();
            r0 = -1;
            r12.memoizedIsInitialized = r0;
            r0 = -1;
            r12.memoizedSerializedSize = r0;
            r12.initFields();
            r3 = 0;
            r5 = com.google.tagmanager.protobuf.ByteString.newOutput();
            r6 = com.google.tagmanager.protobuf.CodedOutputStream.newInstance(r5);
            r2 = 0;
        L_0x001d:
            if (r2 != 0) goto L_0x010f;
        L_0x001f:
            r0 = r13.readTag();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            switch(r0) {
                case 0: goto L_0x0031;
                case 10: goto L_0x0034;
                case 18: goto L_0x0050;
                case 26: goto L_0x006c;
                case 34: goto L_0x0088;
                case 42: goto L_0x00a4;
                case 50: goto L_0x00c1;
                case 58: goto L_0x00e0;
                default: goto L_0x0026;
            };	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
        L_0x0026:
            r0 = r12.parseUnknownField(r13, r6, r14, r0);	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            if (r0 != 0) goto L_0x0215;
        L_0x002c:
            r0 = r1;
            r2 = r3;
        L_0x002e:
            r3 = r2;
            r2 = r0;
            goto L_0x001d;
        L_0x0031:
            r0 = r1;
            r2 = r3;
            goto L_0x002e;
        L_0x0034:
            r0 = r3 & 1;
            if (r0 == r1) goto L_0x0212;
        L_0x0038:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r12.positivePredicates_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r3 | 1;
        L_0x0041:
            r3 = r12.positivePredicates_;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = r13.readMessage(r4, r14);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r11 = r2;
            r2 = r0;
            r0 = r11;
            goto L_0x002e;
        L_0x0050:
            r0 = r3 & 2;
            if (r0 == r7) goto L_0x020f;
        L_0x0054:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r12.negativePredicates_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r3 | 2;
        L_0x005d:
            r3 = r12.negativePredicates_;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = r13.readMessage(r4, r14);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r11 = r2;
            r2 = r0;
            r0 = r11;
            goto L_0x002e;
        L_0x006c:
            r0 = r3 & 4;
            if (r0 == r8) goto L_0x020c;
        L_0x0070:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r12.addTags_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r3 | 4;
        L_0x0079:
            r3 = r12.addTags_;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = r13.readMessage(r4, r14);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r11 = r2;
            r2 = r0;
            r0 = r11;
            goto L_0x002e;
        L_0x0088:
            r0 = r3 & 8;
            if (r0 == r9) goto L_0x0209;
        L_0x008c:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r12.removeTags_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r3 | 8;
        L_0x0095:
            r3 = r12.removeTags_;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = r13.readMessage(r4, r14);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r11 = r2;
            r2 = r0;
            r0 = r11;
            goto L_0x002e;
        L_0x00a4:
            r0 = r3 & 16;
            if (r0 == r10) goto L_0x0206;
        L_0x00a8:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r12.addMacros_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r3 | 16;
        L_0x00b1:
            r3 = r12.addMacros_;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = r13.readMessage(r4, r14);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r11 = r2;
            r2 = r0;
            r0 = r11;
            goto L_0x002e;
        L_0x00c1:
            r0 = r3 & 32;
            r4 = 32;
            if (r0 == r4) goto L_0x0203;
        L_0x00c7:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r12.removeMacros_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r3 | 32;
        L_0x00d0:
            r3 = r12.removeMacros_;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r4 = r13.readMessage(r4, r14);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x01fb, IOException -> 0x01f7, all -> 0x01f3 }
            r11 = r2;
            r2 = r0;
            r0 = r11;
            goto L_0x002e;
        L_0x00e0:
            r0 = 0;
            r4 = r12.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r4 = r4 & 1;
            if (r4 != r1) goto L_0x0200;
        L_0x00e7:
            r0 = r12.result_;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r0.toBuilder();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r4 = r0;
        L_0x00ee:
            r0 = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r13.readMessage(r0, r14);	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r12.result_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            if (r4 == 0) goto L_0x0105;
        L_0x00fa:
            r0 = r12.result_;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r4.mergeFrom(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r4.buildPartial();	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r12.result_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
        L_0x0105:
            r0 = r12.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r0 | 1;
            r12.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0176, IOException -> 0x01d4 }
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x010f:
            r0 = r3 & 1;
            if (r0 != r1) goto L_0x011b;
        L_0x0113:
            r0 = r12.positivePredicates_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.positivePredicates_ = r0;
        L_0x011b:
            r0 = r3 & 2;
            if (r0 != r7) goto L_0x0127;
        L_0x011f:
            r0 = r12.negativePredicates_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.negativePredicates_ = r0;
        L_0x0127:
            r0 = r3 & 4;
            if (r0 != r8) goto L_0x0133;
        L_0x012b:
            r0 = r12.addTags_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.addTags_ = r0;
        L_0x0133:
            r0 = r3 & 8;
            if (r0 != r9) goto L_0x013f;
        L_0x0137:
            r0 = r12.removeTags_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.removeTags_ = r0;
        L_0x013f:
            r0 = r3 & 16;
            if (r0 != r10) goto L_0x014b;
        L_0x0143:
            r0 = r12.addMacros_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.addMacros_ = r0;
        L_0x014b:
            r0 = r3 & 32;
            r1 = 32;
            if (r0 != r1) goto L_0x0159;
        L_0x0151:
            r0 = r12.removeMacros_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.removeMacros_ = r0;
        L_0x0159:
            r6.flush();	 Catch:{ IOException -> 0x0166, all -> 0x016e }
            r0 = r5.toByteString();
            r12.unknownFields = r0;
        L_0x0162:
            r12.makeExtensionsImmutable();
            return;
        L_0x0166:
            r0 = move-exception;
            r0 = r5.toByteString();
            r12.unknownFields = r0;
            goto L_0x0162;
        L_0x016e:
            r0 = move-exception;
            r1 = r5.toByteString();
            r12.unknownFields = r1;
            throw r0;
        L_0x0176:
            r0 = move-exception;
        L_0x0177:
            r0 = r0.setUnfinishedMessage(r12);	 Catch:{ all -> 0x017c }
            throw r0;	 Catch:{ all -> 0x017c }
        L_0x017c:
            r0 = move-exception;
        L_0x017d:
            r2 = r3 & 1;
            if (r2 != r1) goto L_0x0189;
        L_0x0181:
            r1 = r12.positivePredicates_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r12.positivePredicates_ = r1;
        L_0x0189:
            r1 = r3 & 2;
            if (r1 != r7) goto L_0x0195;
        L_0x018d:
            r1 = r12.negativePredicates_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r12.negativePredicates_ = r1;
        L_0x0195:
            r1 = r3 & 4;
            if (r1 != r8) goto L_0x01a1;
        L_0x0199:
            r1 = r12.addTags_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r12.addTags_ = r1;
        L_0x01a1:
            r1 = r3 & 8;
            if (r1 != r9) goto L_0x01ad;
        L_0x01a5:
            r1 = r12.removeTags_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r12.removeTags_ = r1;
        L_0x01ad:
            r1 = r3 & 16;
            if (r1 != r10) goto L_0x01b9;
        L_0x01b1:
            r1 = r12.addMacros_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r12.addMacros_ = r1;
        L_0x01b9:
            r1 = r3 & 32;
            r2 = 32;
            if (r1 != r2) goto L_0x01c7;
        L_0x01bf:
            r1 = r12.removeMacros_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r12.removeMacros_ = r1;
        L_0x01c7:
            r6.flush();	 Catch:{ IOException -> 0x01e3, all -> 0x01eb }
            r1 = r5.toByteString();
            r12.unknownFields = r1;
        L_0x01d0:
            r12.makeExtensionsImmutable();
            throw r0;
        L_0x01d4:
            r0 = move-exception;
        L_0x01d5:
            r2 = new com.google.tagmanager.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x017c }
            r0 = r0.getMessage();	 Catch:{ all -> 0x017c }
            r2.<init>(r0);	 Catch:{ all -> 0x017c }
            r0 = r2.setUnfinishedMessage(r12);	 Catch:{ all -> 0x017c }
            throw r0;	 Catch:{ all -> 0x017c }
        L_0x01e3:
            r1 = move-exception;
            r1 = r5.toByteString();
            r12.unknownFields = r1;
            goto L_0x01d0;
        L_0x01eb:
            r0 = move-exception;
            r1 = r5.toByteString();
            r12.unknownFields = r1;
            throw r0;
        L_0x01f3:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x017d;
        L_0x01f7:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x01d5;
        L_0x01fb:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x0177;
        L_0x0200:
            r4 = r0;
            goto L_0x00ee;
        L_0x0203:
            r0 = r3;
            goto L_0x00d0;
        L_0x0206:
            r0 = r3;
            goto L_0x00b1;
        L_0x0209:
            r0 = r3;
            goto L_0x0095;
        L_0x020c:
            r0 = r3;
            goto L_0x0079;
        L_0x020f:
            r0 = r3;
            goto L_0x005d;
        L_0x0212:
            r0 = r3;
            goto L_0x0041;
        L_0x0215:
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.containertag.proto.Debug.ResolvedRule.<init>(com.google.tagmanager.protobuf.CodedInputStream, com.google.tagmanager.protobuf.ExtensionRegistryLite):void");
        }

        private ResolvedRule(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ResolvedRule(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ResolvedRule getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.positivePredicates_ = Collections.emptyList();
            this.negativePredicates_ = Collections.emptyList();
            this.addTags_ = Collections.emptyList();
            this.removeTags_ = Collections.emptyList();
            this.addMacros_ = Collections.emptyList();
            this.removeMacros_ = Collections.emptyList();
            this.result_ = Value.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ResolvedRule resolvedRule) {
            return newBuilder().mergeFrom(resolvedRule);
        }

        public static ResolvedRule parseDelimitedFrom(InputStream inputStream) {
            return (ResolvedRule) PARSER.parseDelimitedFrom(inputStream);
        }

        public static ResolvedRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedRule) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ResolvedRule parseFrom(ByteString byteString) {
            return (ResolvedRule) PARSER.parseFrom(byteString);
        }

        public static ResolvedRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedRule) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ResolvedRule parseFrom(CodedInputStream codedInputStream) {
            return (ResolvedRule) PARSER.parseFrom(codedInputStream);
        }

        public static ResolvedRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedRule) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ResolvedRule parseFrom(InputStream inputStream) {
            return (ResolvedRule) PARSER.parseFrom(inputStream);
        }

        public static ResolvedRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedRule) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ResolvedRule parseFrom(byte[] bArr) {
            return (ResolvedRule) PARSER.parseFrom(bArr);
        }

        public static ResolvedRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ResolvedRule) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedRule)) {
                return super.equals(obj);
            }
            ResolvedRule resolvedRule = (ResolvedRule) obj;
            boolean z = (getPositivePredicatesList().equals(resolvedRule.getPositivePredicatesList())) && getNegativePredicatesList().equals(resolvedRule.getNegativePredicatesList());
            z = z && getAddTagsList().equals(resolvedRule.getAddTagsList());
            z = z && getRemoveTagsList().equals(resolvedRule.getRemoveTagsList());
            z = z && getAddMacrosList().equals(resolvedRule.getAddMacrosList());
            z = z && getRemoveMacrosList().equals(resolvedRule.getRemoveMacrosList());
            z = z && hasResult() == resolvedRule.hasResult();
            return hasResult() ? z && getResult().equals(resolvedRule.getResult()) : z;
        }

        public ResolvedFunctionCall getAddMacros(int i) {
            return (ResolvedFunctionCall) this.addMacros_.get(i);
        }

        public int getAddMacrosCount() {
            return this.addMacros_.size();
        }

        public List getAddMacrosList() {
            return this.addMacros_;
        }

        public ResolvedFunctionCallOrBuilder getAddMacrosOrBuilder(int i) {
            return (ResolvedFunctionCallOrBuilder) this.addMacros_.get(i);
        }

        public List getAddMacrosOrBuilderList() {
            return this.addMacros_;
        }

        public ResolvedFunctionCall getAddTags(int i) {
            return (ResolvedFunctionCall) this.addTags_.get(i);
        }

        public int getAddTagsCount() {
            return this.addTags_.size();
        }

        public List getAddTagsList() {
            return this.addTags_;
        }

        public ResolvedFunctionCallOrBuilder getAddTagsOrBuilder(int i) {
            return (ResolvedFunctionCallOrBuilder) this.addTags_.get(i);
        }

        public List getAddTagsOrBuilderList() {
            return this.addTags_;
        }

        public ResolvedRule getDefaultInstanceForType() {
            return defaultInstance;
        }

        public ResolvedFunctionCall getNegativePredicates(int i) {
            return (ResolvedFunctionCall) this.negativePredicates_.get(i);
        }

        public int getNegativePredicatesCount() {
            return this.negativePredicates_.size();
        }

        public List getNegativePredicatesList() {
            return this.negativePredicates_;
        }

        public ResolvedFunctionCallOrBuilder getNegativePredicatesOrBuilder(int i) {
            return (ResolvedFunctionCallOrBuilder) this.negativePredicates_.get(i);
        }

        public List getNegativePredicatesOrBuilderList() {
            return this.negativePredicates_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedFunctionCall getPositivePredicates(int i) {
            return (ResolvedFunctionCall) this.positivePredicates_.get(i);
        }

        public int getPositivePredicatesCount() {
            return this.positivePredicates_.size();
        }

        public List getPositivePredicatesList() {
            return this.positivePredicates_;
        }

        public ResolvedFunctionCallOrBuilder getPositivePredicatesOrBuilder(int i) {
            return (ResolvedFunctionCallOrBuilder) this.positivePredicates_.get(i);
        }

        public List getPositivePredicatesOrBuilderList() {
            return this.positivePredicates_;
        }

        public ResolvedFunctionCall getRemoveMacros(int i) {
            return (ResolvedFunctionCall) this.removeMacros_.get(i);
        }

        public int getRemoveMacrosCount() {
            return this.removeMacros_.size();
        }

        public List getRemoveMacrosList() {
            return this.removeMacros_;
        }

        public ResolvedFunctionCallOrBuilder getRemoveMacrosOrBuilder(int i) {
            return (ResolvedFunctionCallOrBuilder) this.removeMacros_.get(i);
        }

        public List getRemoveMacrosOrBuilderList() {
            return this.removeMacros_;
        }

        public ResolvedFunctionCall getRemoveTags(int i) {
            return (ResolvedFunctionCall) this.removeTags_.get(i);
        }

        public int getRemoveTagsCount() {
            return this.removeTags_.size();
        }

        public List getRemoveTagsList() {
            return this.removeTags_;
        }

        public ResolvedFunctionCallOrBuilder getRemoveTagsOrBuilder(int i) {
            return (ResolvedFunctionCallOrBuilder) this.removeTags_.get(i);
        }

        public List getRemoveTagsOrBuilderList() {
            return this.removeTags_;
        }

        public Value getResult() {
            return this.result_;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3;
            int i4 = 0;
            for (i3 = 0; i3 < this.positivePredicates_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.positivePredicates_.get(i3));
            }
            for (i3 = 0; i3 < this.negativePredicates_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.negativePredicates_.get(i3));
            }
            for (i3 = 0; i3 < this.addTags_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.addTags_.get(i3));
            }
            for (i3 = 0; i3 < this.removeTags_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.removeTags_.get(i3));
            }
            for (i3 = 0; i3 < this.addMacros_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.addMacros_.get(i3));
            }
            while (i < this.removeMacros_.size()) {
                i4 += CodedOutputStream.computeMessageSize(6, (MessageLite) this.removeMacros_.get(i));
                i++;
            }
            if ((this.bitField0_ & 1) == 1) {
                i4 += CodedOutputStream.computeMessageSize(7, this.result_);
            }
            i2 = this.unknownFields.size() + i4;
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public boolean hasResult() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ResolvedRule.class.hashCode() + 779;
            if (getPositivePredicatesCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getPositivePredicatesList().hashCode();
            }
            if (getNegativePredicatesCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getNegativePredicatesList().hashCode();
            }
            if (getAddTagsCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getAddTagsList().hashCode();
            }
            if (getRemoveTagsCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getRemoveTagsList().hashCode();
            }
            if (getAddMacrosCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getAddMacrosList().hashCode();
            }
            if (getRemoveMacrosCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getRemoveMacrosList().hashCode();
            }
            if (hasResult()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getResult().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedRule");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            boolean z = true;
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                if (b != (byte) 1) {
                    z = false;
                }
                return z;
            }
            int i = 0;
            while (i < getPositivePredicatesCount()) {
                if (getPositivePredicates(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getNegativePredicatesCount()) {
                if (getNegativePredicates(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getAddTagsCount()) {
                if (getAddTags(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getRemoveTagsCount()) {
                if (getRemoveTags(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getAddMacrosCount()) {
                if (getAddMacros(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getRemoveMacrosCount()) {
                if (getRemoveMacros(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasResult() || getResult().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            getSerializedSize();
            for (i = 0; i < this.positivePredicates_.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.positivePredicates_.get(i));
            }
            for (i = 0; i < this.negativePredicates_.size(); i++) {
                codedOutputStream.writeMessage(2, (MessageLite) this.negativePredicates_.get(i));
            }
            for (i = 0; i < this.addTags_.size(); i++) {
                codedOutputStream.writeMessage(3, (MessageLite) this.addTags_.get(i));
            }
            for (i = 0; i < this.removeTags_.size(); i++) {
                codedOutputStream.writeMessage(4, (MessageLite) this.removeTags_.get(i));
            }
            for (i = 0; i < this.addMacros_.size(); i++) {
                codedOutputStream.writeMessage(5, (MessageLite) this.addMacros_.get(i));
            }
            while (i2 < this.removeMacros_.size()) {
                codedOutputStream.writeMessage(6, (MessageLite) this.removeMacros_.get(i2));
                i2++;
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(7, this.result_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface RuleEvaluationStepInfoOrBuilder extends MessageLiteOrBuilder {
        ResolvedFunctionCall getEnabledFunctions(int i);

        int getEnabledFunctionsCount();

        List getEnabledFunctionsList();

        ResolvedRule getRules(int i);

        int getRulesCount();

        List getRulesList();
    }

    public final class RuleEvaluationStepInfo extends GeneratedMessageLite implements RuleEvaluationStepInfoOrBuilder {
        public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
        public static Parser PARSER = new C0159j();
        public static final int RULES_FIELD_NUMBER = 1;
        private static final RuleEvaluationStepInfo defaultInstance = new RuleEvaluationStepInfo(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private List enabledFunctions_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List rules_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements RuleEvaluationStepInfoOrBuilder {
            private int bitField0_;
            private List enabledFunctions_ = Collections.emptyList();
            private List rules_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureEnabledFunctionsIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.enabledFunctions_ = new ArrayList(this.enabledFunctions_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureRulesIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.rules_ = new ArrayList(this.rules_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAllEnabledFunctions(Iterable iterable) {
                ensureEnabledFunctionsIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.enabledFunctions_);
                return this;
            }

            public Builder addAllRules(Iterable iterable) {
                ensureRulesIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.rules_);
                return this;
            }

            public Builder addEnabledFunctions(int i, Builder builder) {
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.add(i, builder.build());
                return this;
            }

            public Builder addEnabledFunctions(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.add(i, resolvedFunctionCall);
                return this;
            }

            public Builder addEnabledFunctions(Builder builder) {
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.add(builder.build());
                return this;
            }

            public Builder addEnabledFunctions(ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.add(resolvedFunctionCall);
                return this;
            }

            public Builder addRules(int i, Builder builder) {
                ensureRulesIsMutable();
                this.rules_.add(i, builder.build());
                return this;
            }

            public Builder addRules(int i, ResolvedRule resolvedRule) {
                if (resolvedRule == null) {
                    throw new NullPointerException();
                }
                ensureRulesIsMutable();
                this.rules_.add(i, resolvedRule);
                return this;
            }

            public Builder addRules(Builder builder) {
                ensureRulesIsMutable();
                this.rules_.add(builder.build());
                return this;
            }

            public Builder addRules(ResolvedRule resolvedRule) {
                if (resolvedRule == null) {
                    throw new NullPointerException();
                }
                ensureRulesIsMutable();
                this.rules_.add(resolvedRule);
                return this;
            }

            public RuleEvaluationStepInfo build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public RuleEvaluationStepInfo buildPartial() {
                RuleEvaluationStepInfo ruleEvaluationStepInfo = new RuleEvaluationStepInfo((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                    this.bitField0_ &= -2;
                }
                ruleEvaluationStepInfo.rules_ = this.rules_;
                if ((this.bitField0_ & 2) == 2) {
                    this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
                    this.bitField0_ &= -3;
                }
                ruleEvaluationStepInfo.enabledFunctions_ = this.enabledFunctions_;
                return ruleEvaluationStepInfo;
            }

            public Builder clear() {
                super.clear();
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.enabledFunctions_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearEnabledFunctions() {
                this.enabledFunctions_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearRules() {
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public RuleEvaluationStepInfo getDefaultInstanceForType() {
                return RuleEvaluationStepInfo.getDefaultInstance();
            }

            public ResolvedFunctionCall getEnabledFunctions(int i) {
                return (ResolvedFunctionCall) this.enabledFunctions_.get(i);
            }

            public int getEnabledFunctionsCount() {
                return this.enabledFunctions_.size();
            }

            public List getEnabledFunctionsList() {
                return Collections.unmodifiableList(this.enabledFunctions_);
            }

            public ResolvedRule getRules(int i) {
                return (ResolvedRule) this.rules_.get(i);
            }

            public int getRulesCount() {
                return this.rules_.size();
            }

            public List getRulesList() {
                return Collections.unmodifiableList(this.rules_);
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getRulesCount(); i++) {
                    if (!getRules(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getEnabledFunctionsCount(); i++) {
                    if (!getEnabledFunctions(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
                if (ruleEvaluationStepInfo != RuleEvaluationStepInfo.getDefaultInstance()) {
                    if (!ruleEvaluationStepInfo.rules_.isEmpty()) {
                        if (this.rules_.isEmpty()) {
                            this.rules_ = ruleEvaluationStepInfo.rules_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRulesIsMutable();
                            this.rules_.addAll(ruleEvaluationStepInfo.rules_);
                        }
                    }
                    if (!ruleEvaluationStepInfo.enabledFunctions_.isEmpty()) {
                        if (this.enabledFunctions_.isEmpty()) {
                            this.enabledFunctions_ = ruleEvaluationStepInfo.enabledFunctions_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureEnabledFunctionsIsMutable();
                            this.enabledFunctions_.addAll(ruleEvaluationStepInfo.enabledFunctions_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(ruleEvaluationStepInfo.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                RuleEvaluationStepInfo ruleEvaluationStepInfo;
                Throwable th;
                RuleEvaluationStepInfo ruleEvaluationStepInfo2;
                try {
                    ruleEvaluationStepInfo = (RuleEvaluationStepInfo) RuleEvaluationStepInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (ruleEvaluationStepInfo != null) {
                        mergeFrom(ruleEvaluationStepInfo);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    ruleEvaluationStepInfo = (RuleEvaluationStepInfo) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    ruleEvaluationStepInfo2 = ruleEvaluationStepInfo;
                    th = th3;
                }
                if (ruleEvaluationStepInfo2 != null) {
                    mergeFrom(ruleEvaluationStepInfo2);
                }
                throw th;
            }

            public Builder removeEnabledFunctions(int i) {
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.remove(i);
                return this;
            }

            public Builder removeRules(int i) {
                ensureRulesIsMutable();
                this.rules_.remove(i);
                return this;
            }

            public Builder setEnabledFunctions(int i, Builder builder) {
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.set(i, builder.build());
                return this;
            }

            public Builder setEnabledFunctions(int i, ResolvedFunctionCall resolvedFunctionCall) {
                if (resolvedFunctionCall == null) {
                    throw new NullPointerException();
                }
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.set(i, resolvedFunctionCall);
                return this;
            }

            public Builder setRules(int i, Builder builder) {
                ensureRulesIsMutable();
                this.rules_.set(i, builder.build());
                return this;
            }

            public Builder setRules(int i, ResolvedRule resolvedRule) {
                if (resolvedRule == null) {
                    throw new NullPointerException();
                }
                ensureRulesIsMutable();
                this.rules_.set(i, resolvedRule);
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private RuleEvaluationStepInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Object obj = null;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            int i = 0;
            while (obj == null) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            obj = 1;
                            break;
                        case 10:
                            if ((i & 1) != 1) {
                                this.rules_ = new ArrayList();
                                i |= 1;
                            }
                            this.rules_.add(codedInputStream.readMessage(ResolvedRule.PARSER, extensionRegistryLite));
                            break;
                        case 18:
                            if ((i & 2) != 2) {
                                this.enabledFunctions_ = new ArrayList();
                                i |= 2;
                            }
                            this.enabledFunctions_.add(codedInputStream.readMessage(ResolvedFunctionCall.PARSER, extensionRegistryLite));
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.rules_ = Collections.unmodifiableList(this.rules_);
                    }
                    if ((i & 2) == 2) {
                        this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = newOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            if ((i & 1) == 1) {
                this.rules_ = Collections.unmodifiableList(this.rules_);
            }
            if ((i & 2) == 2) {
                this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private RuleEvaluationStepInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RuleEvaluationStepInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static RuleEvaluationStepInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.rules_ = Collections.emptyList();
            this.enabledFunctions_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
            return newBuilder().mergeFrom(ruleEvaluationStepInfo);
        }

        public static RuleEvaluationStepInfo parseDelimitedFrom(InputStream inputStream) {
            return (RuleEvaluationStepInfo) PARSER.parseDelimitedFrom(inputStream);
        }

        public static RuleEvaluationStepInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RuleEvaluationStepInfo) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static RuleEvaluationStepInfo parseFrom(ByteString byteString) {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(byteString);
        }

        public static RuleEvaluationStepInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static RuleEvaluationStepInfo parseFrom(CodedInputStream codedInputStream) {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(codedInputStream);
        }

        public static RuleEvaluationStepInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static RuleEvaluationStepInfo parseFrom(InputStream inputStream) {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(inputStream);
        }

        public static RuleEvaluationStepInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static RuleEvaluationStepInfo parseFrom(byte[] bArr) {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(bArr);
        }

        public static RuleEvaluationStepInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RuleEvaluationStepInfo)) {
                return super.equals(obj);
            }
            RuleEvaluationStepInfo ruleEvaluationStepInfo = (RuleEvaluationStepInfo) obj;
            return (getRulesList().equals(ruleEvaluationStepInfo.getRulesList())) && getEnabledFunctionsList().equals(ruleEvaluationStepInfo.getEnabledFunctionsList());
        }

        public RuleEvaluationStepInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public ResolvedFunctionCall getEnabledFunctions(int i) {
            return (ResolvedFunctionCall) this.enabledFunctions_.get(i);
        }

        public int getEnabledFunctionsCount() {
            return this.enabledFunctions_.size();
        }

        public List getEnabledFunctionsList() {
            return this.enabledFunctions_;
        }

        public ResolvedFunctionCallOrBuilder getEnabledFunctionsOrBuilder(int i) {
            return (ResolvedFunctionCallOrBuilder) this.enabledFunctions_.get(i);
        }

        public List getEnabledFunctionsOrBuilderList() {
            return this.enabledFunctions_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedRule getRules(int i) {
            return (ResolvedRule) this.rules_.get(i);
        }

        public int getRulesCount() {
            return this.rules_.size();
        }

        public List getRulesList() {
            return this.rules_;
        }

        public ResolvedRuleOrBuilder getRulesOrBuilder(int i) {
            return (ResolvedRuleOrBuilder) this.rules_.get(i);
        }

        public List getRulesOrBuilderList() {
            return this.rules_;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.rules_.size(); i4++) {
                i3 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.rules_.get(i4));
            }
            while (i < this.enabledFunctions_.size()) {
                i3 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.enabledFunctions_.get(i));
                i++;
            }
            i2 = this.unknownFields.size() + i3;
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = RuleEvaluationStepInfo.class.hashCode() + 779;
            if (getRulesCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getRulesList().hashCode();
            }
            if (getEnabledFunctionsCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getEnabledFunctionsList().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$RuleEvaluationStepInfo");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                int i = 0;
                while (i < getRulesCount()) {
                    if (getRules(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < getEnabledFunctionsCount()) {
                    if (getEnabledFunctions(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            int i = 0;
            getSerializedSize();
            for (int i2 = 0; i2 < this.rules_.size(); i2++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.rules_.get(i2));
            }
            while (i < this.enabledFunctions_.size()) {
                codedOutputStream.writeMessage(2, (MessageLite) this.enabledFunctions_.get(i));
                i++;
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    private Debug() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(MacroEvaluationInfo.macro);
    }
}
