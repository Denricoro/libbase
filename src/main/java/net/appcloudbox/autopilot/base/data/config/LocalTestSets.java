package net.appcloudbox.autopilot.base.data.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.data.topic.Topic;
import net.appcloudbox.autopilot.base.utils.AcbLog;
import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.List;
import java.util.Map;

public final class LocalTestSets {
    @NonNull
    private final Map<String/* topicId */, TopicTestSets> topicIdToTopicTestSetsMap;

    public LocalTestSets(@NonNull Map<String, TopicTestSets> topicIdToTopicTestSetsMap) {
        this.topicIdToTopicTestSetsMap = BaseUtils.unmodifiableMap(topicIdToTopicTestSetsMap);
    }

    @NonNull
    public Map<String, TopicTestSets> getTopicIdToTopicTestSetsMap() {
        return topicIdToTopicTestSetsMap;
    }

    public static final class TopicTestSets {
        @NonNull
        private final String topicId;
        @NonNull
        private final Map<String, TestSet> idToTestSetsMap;
        @NonNull
        private final List<String> testSetOrder;

        public TopicTestSets(@NonNull String topicId,
                             @NonNull Map<String, TestSet> idToTestSetsMap,
                             @NonNull List<String> testSetOrder) {
            this.topicId = topicId;
            this.idToTestSetsMap = BaseUtils.unmodifiableMap(idToTestSetsMap);
            this.testSetOrder = BaseUtils.unmodifiableList(testSetOrder);
        }

        @NonNull
        public String getTopicId() {
            return topicId;
        }

        @NonNull
        public Map<String, TestSet> getIdToTestSetsMap() {
            return idToTestSetsMap;
        }

        @NonNull
        public List<String> getTestSetOrder() {
            return testSetOrder;
        }
    }

    public static final class TestSet {
        @NonNull
        private final String testSetId;
        private final int maxTestUserRatio;
        @NonNull
        private final List<Topic> cases;
        @NonNull
        private final Audiences audiences;

        public TestSet(@NonNull String testSetId,
                       int maxTestUserRatio,
                       @NonNull List<Topic> cases,
                       @NonNull Audiences audiences) {
            this.testSetId = testSetId;
            this.maxTestUserRatio = maxTestUserRatio;
            this.cases = BaseUtils.unmodifiableList(cases);
            this.audiences = audiences;
        }

        @NonNull
        public String getTestSetId() {
            return testSetId;
        }

        public int getMaxTestUserRatio() {
            return maxTestUserRatio;
        }

        @NonNull
        public List<Topic> getCases() {
            return cases;
        }

        @NonNull
        public Audiences getAudiences() {
            return audiences;
        }
    }

    public static final class Audiences {
        @NonNull
        private final Map<String/* audience name */, Audience> nameToAudienceMap;

        public Audiences(@NonNull Map<String, Audience> nameToAudienceMap) {
            this.nameToAudienceMap = BaseUtils.unmodifiableMap(nameToAudienceMap);
        }

        @NonNull
        public Map<String, Audience> getNameToAudienceMap() {
            return nameToAudienceMap;
        }

        public static final class Audience {
            @NonNull
            private final String name;
            @Nullable
            private final Operation operation;
            @NonNull
            private final List<Value<?>> values;

            public Audience(@NonNull String name,
                            @Nullable Operation operation,
                            @NonNull List<Value<?>> values) {
                this.name = name;
                this.operation = operation;
                this.values = BaseUtils.unmodifiableList(values);
            }

            @NonNull
            public String getName() {
                return name;
            }

            @Nullable
            public Operation getOperation() {
                return operation;
            }

            @NonNull
            public List<Value<?>> getValues() {
                return values;
            }

            public static class Value<T> {
                @NonNull
                private final Op op;
                @NonNull
                private final T value;

                public Value(@NonNull Op op, @NonNull T value) {
                    this.op = op;
                    this.value = value;
                }

                @NonNull
                public Op getOp() {
                    return op;
                }

                @NonNull
                public T getValue() {
                    return value;
                }
            }
        }

        public static final class Operation {
            public static final Operation AND = new Operation("a");
            public static final Operation OR = new Operation("b");
            public static final Operation UNSUPPORTED_TYPE = new Operation("error");

            @NonNull
            private final String name;

            Operation(@NonNull String name) {
                this.name = name;
            }

            @NonNull
            public String getName() {
                return name;
            }

            @NonNull
            public static Operation valueOf(String string) {
                switch (string) {
                    case "a":
                        return AND;
                    case "b":
                        return OR;
                    default:
                        AcbLog.debugAssert("err: unsupported operation '%s'.", string);
                        return UNSUPPORTED_TYPE;
                }
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Operation operation = (Operation) o;
                return name.equals(operation.name);
            }

            @Override
            public int hashCode() {
                return name.hashCode();
            }
        }

        public static final class Op {
            public static final Op EQ = new Op("a");
            public static final Op NE = new Op("b");
            public static final Op GT = new Op("c");
            public static final Op GE = new Op("d");
            public static final Op LT = new Op("e");
            public static final Op LE = new Op("f");
            public static final Op IN = new Op("g");
            public static final Op NI = new Op("h");
            public static final Op UNSUPPORTED_TYPE = new Op("error");

            @NonNull
            private final String name;

            Op(@NonNull String name) {
                this.name = name;
            }

            @NonNull
            public String getName() {
                return name;
            }

            @NonNull
            public static Op valueOf(String string) {
                switch (string) {
                    case "a":
                        return EQ;
                    case "b":
                        return NE;
                    case "c":
                        return GT;
                    case "d":
                        return GE;
                    case "e":
                        return LT;
                    case "f":
                        return LE;
                    case "g":
                        return IN;
                    case "h":
                        return NI;
                    default:
                        AcbLog.debugAssert("err: unsupported op '%s'.", string);
                        return UNSUPPORTED_TYPE;
                }
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Op op = (Op) o;
                return name.equals(op.name);
            }

            @Override
            public int hashCode() {
                return name.hashCode();
            }
        }
    }
}
