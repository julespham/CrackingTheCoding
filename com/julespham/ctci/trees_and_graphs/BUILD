load("@rules_java//java:defs.bzl", "java_library", "java_test")

java_test(
    name = "combined_test",
    srcs = ["CombinedTreeandGraphTest.java"],
    test_class = "com.julespham.ctci.trees_and_graphs.CombinedTreeAndGraphTest",
    deps = [
        ":tree",
    ],
)

java_library(
    name = "tree",
    srcs = ["Tree.java"],
    deps = [],
)

