# CrackingTheCoding
Solved Problems From Cracking the Coding Interview

# Testing

To run the tests, you'll need to first install `bazel`. Once installed it's as simple as running:

```sh
$ bazel test com/julespham/ctci/stacks_and_queues:combined_test
```

Alternatively, you can run the tests within that directory:

```sh
$ cd com/julespham/ctci/stacks_and_queues
$ bazel test :combined_test
```

By default, Bazel will write all the test output to a file. For quick debugging it's useful to print the test output directly to the console. This can be done by adding `--test_output=all` to the above command.
