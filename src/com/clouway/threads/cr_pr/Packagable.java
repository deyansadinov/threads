package com.clouway.threads.cr_pr;


/**
 * Created by clouway on 14-12-13.
 */
public interface Packagable<V> {

  void registerConsumer(Opener<V> opener);

  void registerProducer(Packager<V> packager);

  V unpack();

  void pack(V value);

  boolean isDiscarded();

  void discard();
}
