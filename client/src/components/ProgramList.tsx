import { Link } from 'react-router-dom';
import styled from 'styled-components';

import Program from './Program';

const Contents = styled.ul`
  width: 100%;
  padding: 0 20px 16px;
  display: flex;
  flex-direction: column;
  gap: 12px;

  @media screen and (min-width: 768px) {
    width: 700px;
    margin: 0 auto;
    padding: 0 0 24px;
  }
`;

const ProgramList = () => {
  return (
    <Contents>
      <li>
        <Link to='#'>
          <Program />
        </Link>
      </li>
      <li>
        <Link to='#'>
          <Program />
        </Link>
      </li>
      <li>
        <Link to='#'>
          <Program />
        </Link>
      </li>
      <li>
        <Link to='#'>
          <Program />
        </Link>
      </li>
    </Contents>
  );
};

export default ProgramList;
