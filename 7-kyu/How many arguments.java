/*
DESCRIPTION:
args_count(1, 2, 3) -> 3
args_count(1, 2, 3, 10) -> 4
*/

class Arguments {
  public static int countArgs(Object... args) {
    return args.length;
  }
}