load("@rules_java//java:defs.bzl", "java_library", "java_test")

java_test(
    name = "combined_test",
    srcs = ["CombinedTest.java"],
    test_class = "com.julespham.ctci.stacks_and_queues.CombinedTest",
    deps = [
        ":min_stack",
        ":multi_stack",
        ":my_queue",
        ":set_of_stacks",
        ":stack",
        ":sort_stack",
        ":animal",
        ":animal_shelter"
    ],
)

java_library(
    name = "min_stack",
    srcs = ["MinStack.java"],
    deps = [],
)

java_library(
    name = "my_queue",
    srcs = ["MyQueue.java"],
    deps = [
        ":stack",
    ],
)

java_library(
    name = "multi_stack",
    srcs = ["MultiStack.java"],
    deps = [],
)

java_library(
    name = "sort_stack",
    srcs = ["SortStack.java"],
    deps = [
        ":stack",
    ],
)

java_library(
    name = "set_of_stacks",
    srcs = ["SetOfStacks.java"],
    deps = [
        ":stack",
    ],
)

java_library(
    name = "stack",
    srcs = ["Stack.java"],
    deps = [],
)

java_library(
    name = "animal",
    srcs = ["Animal.java"],
    deps = [],
)

java_library(
    name = "animal_shelter",
    srcs = ["AnimalShelter.java"],
    deps = [
        ":animal"
    ],
)
