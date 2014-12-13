package com.clouway.threads.cr_pr;

/**
 * Created by clouway on 14-12-13.
 */
public class Main {

  public static void main(String[] args) {

    Packagable<String> box = new Box<String>();

    String[] toBePackaged = {"FirstPackage has arrived",
            "SecondPackage has arrived",
            "ThirdPackage has arrived",
            "FourthPackage has arrived"};

    Packager<String> packager = new Packager<String>(box, toBePackaged);

    Opener<String> firstOpener = new Opener<String>(box);
    Opener<String> secondOpener = new Opener<String>(box);
    Opener<String> thirdOpener = new Opener<String>(box);
    Opener<String> fourthOpener = new Opener<String>(box);
    Opener<String> fifthOpener = new Opener<String>(box);
    Opener<String> sixthOpener = new Opener<String>(box);
    Opener<String> seventhOpener = new Opener<String>(box);

    packager.start();
    firstOpener.start();
    secondOpener.start();
    thirdOpener.start();
    fourthOpener.start();
    fifthOpener.start();
    sixthOpener.start();
    seventhOpener.start();
  }


}
