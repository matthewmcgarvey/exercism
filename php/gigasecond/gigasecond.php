<?php

function from(DateTime $date) {
  return DateTimeImmutable::createFromMutable($date)
    ->add(new DateInterval('PT' . pow(10, 9) . 'S'));
}