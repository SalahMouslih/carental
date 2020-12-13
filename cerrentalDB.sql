--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `id` int(3) NOT NULL,
  `name` varchar(25) NOT NULL,
  `matricule` varchar(10) NOT NULL,
  `mark` varchar(15) NOT NULL,
  `model` varchar(15) NOT NULL,
  `year` varchar(4) NOT NULL,
  `killometrage` varchar(15) NOT NULL,
  `rented` tinyint(1) NOT NULL DEFAULT '0',
  `number_rent` int(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`id`, `name`, `matricule`, `mark`, `model`, `year`, `killometrage`, `rented`, `number_rent`) VALUES
(1, 'A.A3.12.765447', '765447', 'Audi', 'A3', '2012', '0 - 30 000', 0, 6),
(2, 'M.E.12.165047', '165047', 'Mercedes', 'Class E', '2012', '0 - 30 000', 1, 2),
(3, 'S.Ib.15.765147', '765147', 'Seat', 'Ibiza', '2015', '0 - 30 000', 1, 4),
(4, 'S.Ib.15.765347', '765347', 'Seat', 'Ibiza', '2015', '90 000 +', 1, 2),
(5, 'M.A.12.715447', '715447', 'Mercedes', 'Class A', '2012', '0 - 30 000', 1, 1),
(6, 'M.A.12.665447', '665447', 'Mercedes', 'Class A', '2012', '0 - 30 000', 1, 1),
(7, 'A.A3.12.785447', '785447', 'Audi', 'A3', '2012', '0 - 30 000', 0, 5),
(13, 'M.S.14.965447', '965447', 'Mercedes', 'Class S', '2014', '60 000 - 90 000', 0, 2),
(14, 'A.A3.12.234578', '234578', 'Audi', 'A3', '2012', '0 - 30 000', 1, 0),
(15, 'M.Class C.14.234532', '234532', 'Mercedes', 'Class C', '2014', '0 - 30 000', 1, 4),
(16, 'A.A3.12.123456', '123456', 'Audi', 'A3', '2012', '0 - 30 000', 1, 1),
(17, 'V.Golf.13.123545', '123545', 'Volkswagen', 'Golf', '2013', '30 000 - 60 000', 1, 1),
(18, 'A.A3.14.123457', '123457', 'Audi', 'A3', '2014', '0 - 30 000', 0, 2),
(22, 'A.A3.16.659804', '659804', 'Audi', 'A3', '2016', '30 000 - 60 000', 1, 1),
(23, 'V.Golf.15.459800', '459800', 'Volkswagen', 'Golf', '2015', '30 000 - 60 000', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(2) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'salah', 'qwerty');
(2, 'yassine', 'qwerty');
(2, 'agent', 'qwerty');



--
-- Indexes for dumped tables
--

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`matricule`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;